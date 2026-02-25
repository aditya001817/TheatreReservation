package com.theatre.reservation.controller;

import com.theatre.reservation.dto.MovieRequestDto;
import com.theatre.reservation.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movies")

public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllMovies(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "5") int size) {

        System.out.println("Getting all movies");
        return  null;
    }

    @GetMapping("/movie/id/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable long id) {
        System.out.println("Getting movie by id: " + id);
        return  null;
    }

    @GetMapping("/movie/genre/{genre}")
    public ResponseEntity<?> getMovieByGenre(@PathVariable String genre) {
        System.out.println("Getting movie by genre: " + genre);
        return  null;
    }

    @GetMapping("/movie/language/{language}")
    public ResponseEntity<?> getMovieByLanguage(@PathVariable String language) {
        System.out.println("Getting movie by language: " + language);
        return  null;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewMovie(@RequestBody MovieRequestDto movieRequestDto) {
        System.out.println("Creating movie");
        return null;
    }

    @PutMapping("/movie/update/{id}")
    public ResponseEntity<?> updateMovieById(@PathVariable long id, @RequestBody MovieRequestDto movieRequestDto) {
        System.out.println("Updating movie");
        return null;
    }

    @DeleteMapping("/movie/delete/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable long movieId) {
        System.out.println("Deleting movie");
        return null;
    }
}
