package com.theatre.reservation.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/theaters")
public class TheaterController {


    @GetMapping("/theater/all")
    public ResponseEntity<?> getAllTheaters(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size) {
        System.out.println("Getting all Theaters");
        return null;
    }

    @GetMapping("/theater/location/{location}")
    public ResponseEntity<?> getAllTheaterByLocation(@PathVariable String location) {
        System.out.println("Getting theater by location"+location);
        return null;
    }

    @GetMapping("/theater/id/{id}")
    public ResponseEntity<?> getTheaterById(@PathVariable long theaterId) {
        System.out.println("Getting theater by id"+theaterId);
        return null;
    }

    @PostMapping("/theater/create")
    public ResponseEntity<?> createTheater(@RequestBody TheaterRequestDto theaterRequestDto) {
        System.out.println("Creating theater");
        return null;
    }

    @PutMapping("/theater/update/{id}")
    public ResponseEntity<?> updateTheaterById(@PathVariable long id, @RequestBody TheaterRequestDto theaterRequestDto) {
        System.out.println("Updating theater by id"+id);
        return null;
    }

    @DeleteMapping("/theater/delete/{id}")
    public ResponseEntity<?> deleteTheaterById(@PathVariable long id) {
        System.out.println("Deleting theater by id"+id);
        return null;
    }
}
