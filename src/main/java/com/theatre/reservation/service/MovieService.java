package com.theatre.reservation.service;

import com.theatre.reservation.entity.Movie;
import com.theatre.reservation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Page<Movie> getAllMovies(int page, int size) {
        return movieRepository.findAll(PageRequest.of(page, size));
    }
}
