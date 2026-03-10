package com.theatre.reservation.controller;

import com.theatre.reservation.dto.ApiResponseDto;
import com.theatre.reservation.dto.MovieRequestDto;
import com.theatre.reservation.dto.PagedApiResponseDto;
import com.theatre.reservation.entity.Movie;
import com.theatre.reservation.enums.MovieGenre;
import com.theatre.reservation.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")

public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<PagedApiResponseDto> getAllMovies(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "5") int size) {

        System.out.println("Getting all movies");
//        return (ResponseEntity<?>) movieService.getAllMovies(page, size);
        return  null;
    }

    @GetMapping("/movie/id/{id}")
    public ResponseEntity<ApiResponseDto> getMovieById(@PathVariable long id) {
        System.out.println("Getting movie by id: " + id);
        Movie movie = movieService.getMovieById(id);
        return  ResponseEntity.ok(
                ApiResponseDto.builder()
                        .message("Fetching movie with id "+id)
                        .data(movie)
                        .build()
        );
    }

    @GetMapping("/movie/genre/{movieGenre}")
    public ResponseEntity<PagedApiResponseDto> getAllMovieByGenre(@PathVariable("genre") MovieGenre movieGenre) {
        System.out.println("Getting movie by genre: " + movieGenre);
        List<Movie> movie = movieService.getMovieByGenre(movieGenre);
        return  ResponseEntity.ok(
                ApiResponseDto.builder()
                        .message("Fetching movies with genre "+movieGenre)
                        .data(movie)
                        .build()
        );
//        return null;
    }

    @GetMapping("/movie/language/{language}")
    public ResponseEntity<PagedApiResponseDto> getAllMovieByLanguage(@PathVariable String language) {
        System.out.println("Getting movie by language: " + language);
        Movie movie = movieService.getMovieByLanguage(language);
        return  ResponseEntity.ok(
                ApiResponseDto.builder()
                        .message("Fetching movie with language "+language)
                        .data(movie).
                        build()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDto> createNewMovie(@RequestBody MovieRequestDto movieRequestDto) {
        System.out.println("Creating movie");
        Movie movie = movieService.createNewMovie(movieRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponseDto.builder()
                                .message("Movie created")
                                .data(movie)
                                .build()
                );
    }

    @PutMapping("/movie/update/{id}")
    public ResponseEntity<ApiResponseDto> updateMovieById(@PathVariable long id, @RequestBody MovieRequestDto movieRequestDto) {
        System.out.println("Updating movie");
        Movie movie = movieService.updateMovieById(id, movieRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponseDto.builder()
                                .message("Updated movie")
                                .data(movie)
                                .build()
                );
    }

    @DeleteMapping("/movie/delete/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable long movieId) {
        System.out.println("Deleting movie");
        movieService.deleteMovieById(movieId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
