package com.theatre.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")

public class MovieController {

    public ResponseEntity<?> getAllMovies() {
        System.out.println("Getting all movies");
        return  null;
    }

    public ResponseEntity<?> getMovieById(int id) {
        System.out.println("Getting movie by id: " + id);
        return  null;
    }
}
