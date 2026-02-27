package com.theatre.reservation.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public ResponseEntity<?> createTheater(@RequestBody TheaterRequestDto theaterRequestDto) {
        System.out.println("Creating theater");
        return null;
    }

    public ResponseEntity<?> updateTheaterById(@PathVariable long id, @RequestBody TheaterRequestDto theaterRequestDto) {
        System.out.println("Updating theater by id"+id);
        return null;
    }

    public ResponseEntity<?> deleteTheaterById(@PathVariable long id) {
        System.out.println("Deleting theater by id"+id);
        return null;
    }
}
