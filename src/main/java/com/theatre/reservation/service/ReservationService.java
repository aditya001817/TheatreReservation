package com.theatre.reservation.service;

import com.theatre.reservation.dto.ReservationRequestDto;
import com.theatre.reservation.entity.Reservation;
import com.theatre.reservation.enums.ReservationStatus;
import com.theatre.reservation.enums.SeatStatus;
import com.theatre.reservation.exception.ReservationNotFoundException;
import com.theatre.reservation.exception.ShowAlreadyStartedException;
import com.theatre.reservation.exception.UnAuthorizedException;
import com.theatre.reservation.repository.ReservationRepository;
import com.theatre.reservation.repository.SeatRepository;
import com.theatre.reservation.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.theatre.reservation.constant.ExceptionMessages.*;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;
    private final SeatLockManager seatLockManager;

    public ReservationService(ReservationRepository reservationRepository, SeatRepository seatRepository, UserRepository userRepository, SeatLockManager seatLockManager) {
        this.reservationRepository = reservationRepository;
        this.seatRepository = seatRepository;
        this.userRepository = userRepository;
        this.seatLockManager = seatLockManager;
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
        return reservationRepository.findByUsername(username, PageRequest.of(page, size));
    }

    public Reservation createReservation(ReservationRequestDto reservationRequestDto) {
        System.out.println("Into Service Layer");
        return null;
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
        return reservationRepository.findByUsername(currentUsername, PageRequest.of(page, size));
    }

    public Page<Reservation> filterReservation(Long movieId, Long theaterId, Long userId, String reservationStatus, String createdDate, int page, int size) {
        System.out.println("Into Service Layer");
        ReservationStatus reStatus = ReservationStatus.valueOf(reservationStatus);
        return reservationRepository.filterReservation(movieId, theaterId, userId, reStatus, PageRequest.of(page, size));
    }

}
