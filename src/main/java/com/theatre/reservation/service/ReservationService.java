package com.theatre.reservation.service;

import com.theatre.reservation.dto.ReservationRequestDto;
import com.theatre.reservation.entity.Reservation;
import com.theatre.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

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

    public List<Reservation> getAllReservationsForCurrentUser(int page, int size) {
        System.out.println("Into Service Layer");
        return null;
    }

    public Reservation getAllReservationsForCurrentUser(ReservationRequestDto reservationRequestDto) {
        System.out.println("Into Service Layer");
        return null;
    }
}
