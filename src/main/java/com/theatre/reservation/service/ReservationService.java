package com.theatre.reservation.service;

import com.theatre.reservation.dto.ReservationRequestDto;
import com.theatre.reservation.entity.*;
import com.theatre.reservation.enums.ReservationStatus;
import com.theatre.reservation.enums.SeatStatus;
import com.theatre.reservation.exception.*;
import com.theatre.reservation.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

import static com.theatre.reservation.constant.ExceptionMessages.*;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;
    private final SeatLockManager seatLockManager;
    private final ShowRepository showRepository;

    public ReservationService(ReservationRepository reservationRepository, SeatRepository seatRepository, UserRepository userRepository, SeatLockManager seatLockManager, ShowRepository showRepository) {
        this.reservationRepository = reservationRepository;
        this.seatRepository = seatRepository;
        this.userRepository = userRepository;
        this.seatLockManager = seatLockManager;
        this.showRepository = showRepository;
    }

    @Transactional
    public Reservation cancelReservation(long reservationId) {
        System.out.println("Into Service Layer");
        return reservationRepository.findById(reservationId)
                .map(reservation -> {
                    // 1. Check Time
                    if(LocalDateTime.now().isAfter(reservation.getShow().getStartTime())) {
                        throw new ShowAlreadyStartedException(SHOW_STARTED_EXCEPTION, HttpStatus.BAD_REQUEST);
                    }
                    // 2. Free Seats
                    reservation.getSeatsReserved().forEach(seat -> seat.setStatus(SeatStatus.UNBOOKED));
                    seatRepository.saveAll(reservation.getSeatsReserved());
                    reservation.getSeatsReserved().clear();

                    // 3. Updated reservation status
                    reservation.setReservationStatus(ReservationStatus.CANCELED);

                    //4. Save the reservation
                    return reservationRepository.save(reservation);
                })
                .orElseThrow(() -> new ReservationNotFoundException(RESERVATION_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    public Page<Reservation> getAllReservationsForCurrentUser(String username, int page, int size) {
        System.out.println("Into Service Layer");
        return reservationRepository.findByUserUsername(username, PageRequest.of(page, size));
    }

    @Transactional
    public Reservation createReservation(ReservationRequestDto reservationRequestDto) {
        System.out.println("Into Service Layer");
        return showRepository.findById(reservationRequestDto.getShowId())
                .map(show -> {
                    List<Seat> seats = reservationRequestDto
                            .getSeatIdsReserve()
                            .stream()
                            .map(seatRepository::findById)
                            .map(Optional::get)
                            .toList();

                    //CALCULATE AMOUNT
                    double amountTOBePaid = seats.stream().map(Seat::getPrice).reduce(0.0, Double::sum);

                    if(reservationRequestDto.getAmount() != amountTOBePaid) {
                        throw new AmountNotMatchedException(AMOUNT_NOT_MATCHED, HttpStatus.BAD_REQUEST);
                    }

                    //GET ALL SELECTED SEATS LOCKED
                    seats.forEach(seat -> {
                        ReentrantLock lock = seatLockManager.getLockForSeat(seat.getId());
                        boolean isLocked = lock.tryLock();
                        if(!isLocked) {
                            throw new SeatLockAquiredException(SEAT_ACQUIRED, HttpStatus.CONFLICT);
                        }
                    });

                    //CHECK FOR ANY PRE BOOKED SEAT
                    Boolean bookedSeat = seats.stream().map(Seat::getStatus).anyMatch(seatStatus -> seatStatus.equals(SeatStatus.BOOKED));

                    //IF ANY SEAT IS ALREADY BOOKED THEN REMOVE LOCK FOR ALL SEATS
                    if(bookedSeat) {
                        seats.forEach(seat -> {seatLockManager.releaseLockForSeat(seat.getId());});
                        throw new SeatAlreadyBookedException(SEAT_ALREADY_BOOKED , HttpStatus.CONFLICT);
                    }
                });
    }

    public Reservation getReservationById(String currentUsername, long reservationId) {
        System.out.println("Into Service Layer");
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ReservationNotFoundException(RESERVATION_NOT_FOUND, HttpStatus.NOT_FOUND));

        if(!reservation.getUser().getUsername().equals(currentUsername)) {
            throw new UnAuthorizedException(UNAUTHORIZED_USER, HttpStatus.NOT_FOUND);
        }
        return reservation;
    }


    public Page<Reservation> getReservationByUsername(String currentUsername, int page, int size) {
        System.out.println("Into Service Layer");
        return reservationRepository.findByUserUsername(currentUsername, PageRequest.of(page, size));
    }

    public Page<Reservation> filterReservation(Long movieId, Long theaterId, Long userId, String reservationStatus, String createdDate, int page, int size) {
        System.out.println("Into Service Layer");
        ReservationStatus reStatus = ReservationStatus.valueOf(reservationStatus);
        return reservationRepository.filterReservation(movieId, theaterId, userId, reStatus, PageRequest.of(page, size));
    }

}
