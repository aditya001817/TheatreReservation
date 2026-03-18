package com.theatre.reservation.repository;

import com.theatre.reservation.entity.Show;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    Page<Show> findShowBy_MovieId(long movieId, Pageable pageable);
    Page<Show> findShowBy_TheaterId(long theaterId, Pageable pageable);
    Page<Show> findShowBy_TheaterIdAndMovieId(long theaterId, long movieId, Pageable pageable);
}
