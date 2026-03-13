package com.theatre.reservation.service;

import com.theatre.reservation.repository.MovieRepository;
import com.theatre.reservation.repository.SeatRepository;
import com.theatre.reservation.repository.ShowRepository;
import com.theatre.reservation.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
