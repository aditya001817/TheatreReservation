package com.theatre.reservation.controller;


import com.theatre.reservation.dto.ApiResponseDto;
import com.theatre.reservation.dto.TheaterRequestDto;
import com.theatre.reservation.entity.Theater;
import com.theatre.reservation.service.TheaterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/theaters")
public class TheaterController {

    private TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/theater/all")
    public ResponseEntity<?> getAllTheaters(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size) {
        System.out.println("Getting all Theaters");
        return null;
    }

    @GetMapping("/theater/location/{location}")
    public ResponseEntity<?> getAllTheaterByLocation(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "3") int size,
                                                     @PathVariable String location) {
        System.out.println("Getting theater by location"+location);
        return null;
    }

    @GetMapping("/theater/id/{id}")
    public ResponseEntity<ApiResponseDto> getTheaterById(@PathVariable long theaterId) {
        System.out.println("Getting theater by id"+theaterId);
        return null;
    }

    @PostMapping("/theater/create")
    public ResponseEntity<ApiResponseDto> createTheater(@RequestBody TheaterRequestDto theaterRequestDto) {
        System.out.println("Creating theater");
        return null;
    }

    @PutMapping("/theater/update/{id}")
    public ResponseEntity<ApiResponseDto> updateTheaterById(@PathVariable long id, @RequestBody TheaterRequestDto theaterRequestDto) {
        System.out.println("Updating theater by id"+id);
        return null;
    }

    @DeleteMapping("/theater/delete/{id}")
    public ResponseEntity<?> deleteTheaterById(@PathVariable long id) {
        System.out.println("Deleting theater by id"+id);
        return null;
    }

}
