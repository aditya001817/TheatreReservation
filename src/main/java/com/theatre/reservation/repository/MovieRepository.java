package com.theatre.reservation.repository;

import com.theatre.reservation.entity.Movie;
import com.theatre.reservation.enums.MovieGenre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Page<Movie> findAllByMovieLanguage(String language, Pageable pageable);
    Page<Movie> findAllByMovieGenre(MovieGenre genre, Pageable pageable);
}
