package com.theatre.reservation.repository;

import com.theatre.reservation.entity.Show;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    Page<Show> findByMovie_MovieId(long movieId, Pageable pageable);
    Page<Show> findByTheater_TheaterId(long theaterId, Pageable pageable);
    Page<Show> findByTheater_TheaterIdAndMovie_MovieId(long theaterId, long movieId, Pageable pageable);
}
