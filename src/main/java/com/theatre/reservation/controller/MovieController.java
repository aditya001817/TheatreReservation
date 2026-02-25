package com.theatre.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies/")

public class MovieController {

    @GetMapping("/all")
    public ResponseEntity<?> getAllMovies() {
        System.out.println("Getting all movies");
        return  null;
    }

    @GetMapping("/movie/id/{id}")
    public ResponseEntity<?> getMovieById(int id) {
        System.out.println("Getting movie by id: " + id);
        return  null;
    }

    @GetMapping("/movie/genre/{genre}")
    public ResponseEntity<?> getMovieByGenre(String genre) {
        System.out.println("Getting movie by genre: " + genre);
        return  null;
    }

    @GetMapping("/movie/language/{language}")
    public ResponseEntity<?> getMovieByLanguage(String language) {
        System.out.println("Getting movie by language: " + language);
        return  null;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewMovie() {
        System.out.println("Creating movie");
        return null;
    }

    public ResponseEntity<?> updateMovieById() {
        System.out.println("Updating movie");
        return null;
    }

    public ResponseEntity<?> deleteMovieById() {
        System.out.println("Deleting movie");
        return null;
    }
}
