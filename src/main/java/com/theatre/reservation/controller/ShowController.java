package com.theatre.reservation.controller;

import com.theatre.reservation.dto.ApiResponseDto;
import com.theatre.reservation.dto.PagedApiResponseDto;
import com.theatre.reservation.dto.ShowRequestDto;
import com.theatre.reservation.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService1) {
        this.showService = showService1;
    }

    @GetMapping("/all")
    public ResponseEntity<PagedApiResponseDto> getAllShows(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        System.out.println("Getting All Shows");
        return null;
    }

    @GetMapping("/filter")
    public ResponseEntity<PagedApiResponseDto> filterShows(@RequestParam(defaultValue = "0")int page,
                                                           @RequestParam(defaultValue = "10")int size,
                                                           @RequestParam(required = false) long movieId,
                                                           @RequestParam(required = false) long theaterId,
                                                           @RequestParam(required = false) String showDate
                                                           ) {
        System.out.println("Filtering Shows");
        return null;
    }

    @GetMapping("/id/{showId}")
    public ResponseEntity<ApiResponseDto> getShowId(@PathVariable long showId) {
        System.out.println("Fetching show by id "+showId);
        return null;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDto> createShow(@RequestBody ShowRequestDto showRequestDto) {
        System.out.println("Creating show");
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponseDto> deleteShowById(@PathVariable long showId) {
        System.out.println("Deleting show by Id");
        return null;
    }
}
