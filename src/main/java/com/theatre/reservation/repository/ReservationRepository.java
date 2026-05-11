package com.theatre.reservation.repository;

import com.theatre.reservation.entity.Reservation;
import com.theatre.reservation.enums.ReservationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Page<Reservation> findByUserUsername(String username, Pageable pageable);

    @Query("""
            SELECT r FROM Reservation r
            WHERE (:movieId IS NULL OR r.show.movie.movieId = :movieId)
              AND (:theaterId IS NULL OR r.show.theater.theaterId = :theaterId)
              AND (:userId IS NULL OR r.user.userId = :userId)
              AND (:reStatus IS NULL OR r.reservationStatus = :reStatus)
            """)
    Page<Reservation> filterReservation(@Param("movieId") Long movieId,
                                        @Param("theaterId") Long theaterId,
                                        @Param("userId") Long userId,
                                        @Param("reStatus") ReservationStatus reStatus,
                                        Pageable pageable);
}
