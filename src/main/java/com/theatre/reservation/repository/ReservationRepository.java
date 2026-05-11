package com.theatre.reservation.repository;

import com.theatre.reservation.entity.Reservation;
import com.theatre.reservation.enums.ReservationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Page<Reservation> findByUsername(String username, Pageable pageable);
    Page<Reservation>filterReservation(Long movieId, Long theaterId, Long userId, ReservationStatus reStatus, Pageable pageable);
}
