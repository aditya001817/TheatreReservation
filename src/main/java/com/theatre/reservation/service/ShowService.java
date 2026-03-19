package com.theatre.reservation.service;

import com.theatre.reservation.dto.SeatStructure;
import com.theatre.reservation.dto.ShowRequestDto;
import com.theatre.reservation.entity.Seat;
import com.theatre.reservation.entity.Show;
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
            return showRepository.findShowBy_TheaterId(theaterId, pageRequest);
        }
        else if(theaterId == null) {
            return showRepository.findShowBy_MovieId(movieId, pageRequest);
        }
        return showRepository.findShowBy_TheaterIdAndMovieId(theaterId, movieId, pageRequest);
    }

    public Show getShowById(long showId) {
        return showRepository.findById(showId)
                .orElseThrow(() -> new ShowNotFoundException(SHOW_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    public Show createNewShow(ShowRequestDto showRequestDto) {
        System.out.println("Creating new Show");
        return movieRepository.findById(showRequestDto.getMovieId())
                .map(movie -> theaterRepository.findById(showRequestDto.getTheaterId())
                        .map(theater -> {
                            List<Seat> seats = new ArrayList<>();
                            showRequestDto.getSeats()
                                    .forEach(seatStructure ->
                                            seats.addAll(
                                                    seatService.createSeatWithGivenPrice(
                                                            seatStructure.getSeatCount(),
                                                            seatStructure.getSeatPrice(),
                                                            seatStructure.getArea()
                                                    )
                                            ));
                            Show show = Show.builder()
                                    .movie(movie)
                                    .theater(theater)
                                    .startTime(LocalDateTime.parse(showRequestDto.getStartTime()))
                                    .endTime(LocalDateTime.parse(showRequestDto.getEndTime()))
                                    .seats(seats)
                                    .build();
                            return showRepository.save(show);
                        })
                        .orElseThrow(() -> new TheaterNotFoundException(THEATER_NOT_FOUND, HttpStatus.BAD_REQUEST)))
                .orElseThrow(() -> new MovieNotFoundException(MOVIE_NOT_FOUND, HttpStatus.BAD_REQUEST));
    }

    public void deleteShowById(long showId) {
        System.out.println("Deleting show");
        showRepository.deleteById(showId);
    }
}
