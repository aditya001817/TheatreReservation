package com.theatre.reservation.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/theaters")
public class TheaterController {

    public ResponseEntity<?> getAllTheaters(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size) {
        System.out.println("Getting all Theaters");
        return null;
    }

    public ResponseEntity<?> getAllTheaterByLocation(@PathVariable String location) {
        System.out.println("Getting theater by location"+location);
        return null;
    }

    public ResponseEntity<?> getTheaterById(@PathVariable long theaterId) {
        System.out.println("Getting theater by id"+theaterId);
        return null;
    }
}
