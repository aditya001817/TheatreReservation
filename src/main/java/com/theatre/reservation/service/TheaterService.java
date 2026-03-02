package com.theatre.reservation.service;

import com.theatre.reservation.dto.TheaterRequestDto;
import com.theatre.reservation.entity.Theater;
import com.theatre.reservation.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    private TheaterRepository theaterRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public Page<Theater> getAllTheaters(int page, int size) {
        System.out.println("into theater service");
        theaterRepository.findAll(PageRequest.of(page, size));
        return null;
    }

    public Page<Theater> getAllTheaterByLocation(String location, int page, int size) {
        System.out.println("into theater service");
        theaterRepository.findAllByLocation(location, PageRequest.of(page, size));
        return null;
    }

    public Theater getTheaterById(long id) {
        System.out.println("into theater service");
        return null;
    }

    public Theater createTheater(TheaterRequestDto theaterRequestDto) {
        System.out.println("into theater service");
        Theater theater = Theater.builder()
                .name(theaterRequestDto.getName())
                .location(theaterRequestDto.getLocation())
                .build();
        return null;
    }

    public Theater updateTheaterById(long id,  Theater theater) {
        System.out.println("into theater service");
        return null;
    }

    public void deleteTheaterById(long id) {
        System.out.println("into theater service");
    }
}
