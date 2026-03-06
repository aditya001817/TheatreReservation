package com.theatre.reservation.repository;

import com.theatre.reservation.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByMovieLanguage(String language);
}
