package com.theatre.reservation.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/theaters")
public class TheaterController {

    public ResponseEntity<?> getAllTheaters() {
        System.out.println("Getting all Theaters");
        return null;
    }

    public ResponseEntity<?> getAllTheaterByLocation(String location) {
        System.out.println("Getting theater by location"+location);
        return null;
    }
}
