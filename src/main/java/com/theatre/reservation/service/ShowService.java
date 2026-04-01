package com.theatre.reservation.service;

import com.theatre.reservation.dto.SeatStructure;
import com.theatre.reservation.dto.ShowRequestDto;
import com.theatre.reservation.entity.Movie;
import com.theatre.reservation.entity.Seat;
import com.theatre.reservation.entity.Show;
import com.theatre.reservation.entity.Theater;
import com.theatre.reservation.exception.MovieNotFoundException;
import com.theatre.reservation.exception.ShowNotFoundException;
import com.theatre.reservation.exception.TheaterNotFoundException;
import com.theatre.reservation.repository.MovieRepository;
import com.theatre.reservation.repository.SeatRepository;
import com.theatre.reservation.repository.ShowRepository;
import com.theatre.reservation.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.theatre.reservation.constant.ExceptionMessages.*;

@Service
public class ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final SeatService seatService;

    @Autowired
    public ShowService(ShowRepository showRepository, MovieRepository movieRepository, TheaterRepository theaterRepository, SeatService seatService) {
        this.seatService = seatService;
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
    }

    public Page<Show> getAllShows(PageRequest pageRequest) {
        System.out.println("Getting all shows");
        return showRepository.findAll(pageRequest);
    }

    public Page<Show> filterShowByTheaterIdAndMovieId(Long theaterId, Long movieId, PageRequest pageRequest) {
        System.out.println("Filtering shows by theater and movie id");
        if(theaterId==null && movieId==null) {
            return showRepository.findAll(pageRequest);
        } else if (movieId == null) {
            return showRepository.findByTheater_TheaterId(theaterId, pageRequest);
        }
        else if(theaterId == null) {
            return showRepository.findByMovie_MovieId(movieId, pageRequest);
        }
        return showRepository.findByTheater_TheaterIdAndMovie_MovieId(theaterId, movieId, pageRequest);
    }

    public Show getShowById(long showId) {
        return showRepository.findById(showId)
                .orElseThrow(() -> new ShowNotFoundException(SHOW_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    public Show createNewShow(ShowRequestDto showRequestDto) {
        System.out.println("Creating new Show");
        Movie movie = movieRepository.findById(showRequestDto.getMovieId())
                .orElseThrow(() -> new MovieNotFoundException(MOVIE_NOT_FOUND, HttpStatus.BAD_REQUEST));

        Theater theater = theaterRepository.findById(showRequestDto.getTheaterId())
                .orElseThrow(() -> new TheaterNotFoundException(THEATER_NOT_FOUND, HttpStatus.BAD_REQUEST));

    }

    public void deleteShowById(long showId) {
        System.out.println("Deleting show");
        showRepository.deleteById(showId);
    }
}
