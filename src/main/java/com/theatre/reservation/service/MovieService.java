package com.theatre.reservation.service;

import com.theatre.reservation.dto.MovieRequestDto;
import com.theatre.reservation.entity.Movie;
import com.theatre.reservation.enums.MovieGenre;
import com.theatre.reservation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


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

    public Movie getMovieById(long id) {
        System.out.println("Fetching movie with id " + id);
        return movieRepository.findById(id)
                .orElseThrow(null);
    }

    public List<Movie> getMovieByGenre(MovieGenre movieGenre) {
        System.out.println("Fetching movie by genre " + movieGenre);
        return movieRepository.findByMovieGenre(movieGenre);
//        return null;
    }



    public Movie getMovieByLanguage(String movieLanguage) {
        System.out.println("Fetching movie by Language " + movieLanguage);
        return movieRepository.findByMovieLanguage(movieLanguage);
    }

    public Movie createNewMovie(MovieRequestDto movieRequestDto) {
        Movie movie = Movie.builder()
                .movieLanguage(movieRequestDto.getMovieLanguage())
                .movieLength(movieRequestDto.getMovieLength())
                .movieGenre(movieRequestDto.getMovieGenre())
                .movieName(movieRequestDto.getMovieName())
                .releaseDate(LocalDate.parse(movieRequestDto.getReleaseDate()))
                .build();
        movieRepository.save(movie);
        System.out.println("Saved movie id " + movie.getMovieId());
        return movie;
    }

    public Movie updateMovieById(long movieId, MovieRequestDto movieRequestDto) {
        System.out.println("Updating movie " +movieRequestDto);
        return movieRepository.findById(movieId)
                .map(movieInDb -> {
                    movieInDb.setMovieName(movieRequestDto.getMovieName());
                    movieInDb.setReleaseDate(LocalDate.parse(movieRequestDto.getReleaseDate()));
                    movieInDb.setMovieLanguage(movieRequestDto.getMovieLanguage());
                    movieInDb.setMovieLength(movieRequestDto.getMovieLength());
                    movieInDb.setMovieGenre(movieRequestDto.getMovieGenre());

                    return movieRepository.save(movieInDb);
                })
                .orElse(null);
    }

    public void deleteMovieById(long movieId) {
        System.out.println("Deleting movie " + movieId);
        movieRepository.deleteById(movieId);
    }
}
