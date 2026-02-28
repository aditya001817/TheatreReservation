package com.theatre.reservation.service;

import com.theatre.reservation.entity.Theater;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    public Page<Theater> getAllTheaters(int page, int size) {
        System.out.println("into theater service");
        return null;
    }

    public Page<Theater> getAllTheaterByLocation(String location, int page, int size) {
        System.out.println("into theater service");
        return null;
    }

    public Theater getTheaterById(long id) {
        System.out.println("into theater service");
        return null;
    }

    public Theater createTheater(Theater theater) {
        System.out.println("into theater service");
        return null;
    }

    public Theater updateTheaterById(long id,  Theater theater) {
        System.out.println("into theater service");
        return null;
    }

}
