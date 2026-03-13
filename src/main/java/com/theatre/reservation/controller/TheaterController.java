package com.theatre.reservation.controller;


import com.theatre.reservation.dto.ApiResponseDto;
import com.theatre.reservation.dto.PagedApiResponseDto;
import com.theatre.reservation.dto.TheaterRequestDto;
import com.theatre.reservation.entity.Theater;
import com.theatre.reservation.service.TheaterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/theaters")
public class TheaterController {

    private TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/all")
    public ResponseEntity<PagedApiResponseDto> getAllTheaters(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size) {
        System.out.println("Getting all Theaters");
        Page<Theater> pageTheater = theaterService.getAllTheaters(page, size);
        List<Theater> theaters = pageTheater.getContent();
        return ResponseEntity.ok(
                PagedApiResponseDto.builder()
                        .totalPages(pageTheater.getTotalPages())
                        .totalElements(pageTheater.getTotalElements())
                        .currentCount(pageTheater.getNumberOfElements())
                        .currentPageData(theaters)
                        .build()
        );
    }

    @GetMapping("/theater/location/{location}")
    public ResponseEntity<PagedApiResponseDto> getAllTheaterByLocation(@RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "3") int size,
                                                                       @PathVariable String location) {
        System.out.println("Getting theater by location"+location);
        Page<Theater> theaterPage= theaterService.getAllTheaterByLocation(location, page, size);
        List<Theater> theaters = theaterPage.getContent();
        return ResponseEntity.ok(
                PagedApiResponseDto.builder()
                        .totalPages(theaterPage.getTotalPages())
                        .totalElements(theaterPage.getTotalElements())
                        .currentCount(theaterPage.getNumberOfElements())
                        .currentPageData(theaters)
                        .build()
        );
    }

    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<ApiResponseDto> getTheaterById(@PathVariable long theaterId) {
        System.out.println("Getting theater by id"+theaterId);
        Theater theater = theaterService.getTheaterById(theaterId);
        return ResponseEntity.ok(
                ApiResponseDto.builder()
                        .message("Fetching theater")
                        .data(theater)
                        .build()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDto> createTheater(@RequestBody TheaterRequestDto theaterRequestDto) {
        System.out.println("Creating theater");
        Theater theater = theaterService.createTheater(theaterRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponseDto.builder()
                                .message("Theater created successfully")
                                .data(theater)
                                .build()
                );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponseDto> updateTheaterById(@PathVariable long id, @RequestBody TheaterRequestDto theaterRequestDto) {
        System.out.println("Updating theater by id"+id);
        Theater theater = theaterService.updateTheaterById(id, theaterRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponseDto.builder()
                                .message("Updating Movie")
                                .data(theater)
                                .build()
                );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTheaterById(@PathVariable long id) {
        System.out.println("Deleting theater by id"+id);
        theaterService.deleteTheaterById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
