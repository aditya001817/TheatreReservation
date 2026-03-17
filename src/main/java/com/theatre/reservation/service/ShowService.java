package com.theatre.reservation.service;

import com.theatre.reservation.dto.ShowRequestDto;
import com.theatre.reservation.entity.Show;
import com.theatre.reservation.exception.ShowNotFoundException;
import com.theatre.reservation.repository.MovieRepository;
import com.theatre.reservation.repository.SeatRepository;
import com.theatre.reservation.repository.ShowRepository;
import com.theatre.reservation.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.theatre.reservation.constant.ExceptionMessages.SHOW_NOT_FOUND;

@Service
public class ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public ShowService(ShowRepository showRepository, MovieRepository movieRepository, TheaterRepository theaterRepository, SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
    }

    public Page<Show> getAllShows(int page, int size) {
        System.out.println("Getting all shows");
        return showRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Show> filterShowByTheaterIdAndMovieId(Long theaterId, Long movieId, PageRequest pageRequest) {
        System.out.println("Filtering shows by theater and movie id");
        if(theaterId==null && movieId==null) {
            return showRepository.findAll(pageRequest);
        } else if (movieId == null) {
            return showRepository.findByTheaterId(theaterId, pageRequest);
        }
        else if(theaterId == null) {
            return showRepository.findbyMovieId(movieId, pageRequest);
        }
        return showRepository.findByTheaterIdAndMovieId(theaterId, movieId, pageRequest);
    }

    public Show getShowById(long showId) {
        return showRepository.findById(showId)
                .orElseThrow(() -> new ShowNotFoundException(SHOW_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    public Show createNewShow(ShowRequestDto showRequestDto) {
        System.out.println("Creating new Show");
        return null;
    }

    public void deleteShowById(long showId) {
        System.out.println("Deleting show");
        showRepository.deleteById(showId);
    }
}
