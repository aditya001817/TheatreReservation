package com.theatre.reservation.service;

import com.theatre.reservation.dto.ReservationRequestDto;
import com.theatre.reservation.entity.Reservation;
import com.theatre.reservation.repository.ReservationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void cancelReservation(long reservationId) {
        System.out.println("Into Service Layer");
        reservationRepository.deleteById(reservationId);
    }

    public Page<Reservation> getAllReservationsForCurrentUser(int page, int size) {
        System.out.println("Into Service Layer");
        return null;
    }

    public Reservation createReservation(ReservationRequestDto reservationRequestDto) {
        System.out.println("Into Service Layer");
        return null;
    }

    public Reservation getReservationById(long reservationId) {
        System.out.println("Into Service Layer");
        return null;
    }

    public Page<Reservation> filterReservation(Long movieId, Long theaterId, Long userId, String reservationStatus, String createdDate) {
        System.out.println("Into Service Layer");
        return null;
    }

}
