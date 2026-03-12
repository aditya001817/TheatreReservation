package com.theatre.reservation.service;

import com.theatre.reservation.dto.TheaterRequestDto;
import com.theatre.reservation.entity.Theater;
import com.theatre.reservation.exception.TheaterNotFoundException;
import com.theatre.reservation.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.theatre.reservation.constant.ExceptionMessages.THEATER_NOT_FOUND;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public Page<Theater> getAllTheaters(int page, int size) {
        System.out.println("into theater service getAllTheaters");
        return theaterRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Theater> getAllTheaterByLocation(String location, int page, int size) {
        System.out.println("into theater service getAllTheaterByLocation");
        return theaterRepository.findAllByLocation(location, PageRequest.of(page, size));
    }

    public Theater getTheaterById(long theaterId) {
        System.out.println("into theater service getTheaterById");
        return theaterRepository.findById(theaterId)
                .orElseThrow(() -> new TheaterNotFoundException(THEATER_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    public void createTheater(TheaterRequestDto theaterRequestDto) {
        System.out.println("into theater service createTheater");
        Theater theater = Theater.builder()
                .name(theaterRequestDto.getName())
                .location(theaterRequestDto.getLocation())
                .build();
        theaterRepository.save(theater);
        System.out.println("theater created with id " + theater.getId());
    }

    public Theater updateTheaterById(long theaterId,  Theater theater) {
        System.out.println("into theater service updateTheaterById");
        return theaterRepository.findById(theaterId)
                .map(theaterInDb -> {
                    theaterInDb.setName(theater.getName());
                    theaterInDb.setLocation(theater.getLocation());
                    return theaterRepository.save(theaterInDb);
                })
                .orElseThrow(() -> new TheaterNotFoundException(THEATER_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    public void deleteTheaterById(long theaterId) {
        System.out.println("into theater service deleteTheaterById");
        theaterRepository.deleteById(theaterId);
    }
}
