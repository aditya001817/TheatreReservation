package com.theatre.reservation.repository;

import com.theatre.reservation.entity.Movie;
import com.theatre.reservation.enums.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByMovieLanguage(String language);
    List<Movie> findByMovieGenre(MovieGenre genre);
}
