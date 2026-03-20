package com.theatre.reservation.controller;

import com.theatre.reservation.dto.ApiResponseDto;
import com.theatre.reservation.dto.PagedApiResponseDto;
import com.theatre.reservation.dto.ShowRequestDto;
import com.theatre.reservation.entity.Show;
import com.theatre.reservation.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Page<Show> showPage = showService.getAllShows(PageRequest.of(page, size));
        List<Show> shows = showPage.getContent();
        return ResponseEntity.ok(
                PagedApiResponseDto.builder()
                        .totalPages(showPage.getTotalPages())
                        .totalElements(showPage.getTotalElements())
                        .currentCount(showPage.getNumberOfElements())
                        .currentPageData(shows)
                        .build()
        );
    }

    @GetMapping("/filter")
    public ResponseEntity<PagedApiResponseDto> filterShows(@RequestParam(required = false) long movieId,
                                                           @RequestParam(required = false) long theaterId,
                                                           @RequestParam(required = false) String showDate,
                                                           @RequestParam(defaultValue = "0")int page,
                                                           @RequestParam(defaultValue = "10")int size
                                                           ) {
        System.out.println("Filtering Shows");
        Page<Show> showPage = showService.filterShowByTheaterIdAndMovieId(theaterId, movieId, PageRequest.of(page,  size));
        List<Show> shows = showPage.getContent();
        return ResponseEntity.ok(
                PagedApiResponseDto.builder()
                        .totalPages(showPage.getTotalPages())
                        .totalElements(showPage.getTotalElements())
                        .currentCount(showPage.getNumberOfElements())
                        .currentPageData(shows)
                        .build()
        );
    }

    @GetMapping("/id/{showId}")
    public ResponseEntity<ApiResponseDto> getShowId(@PathVariable long showId) {
        System.out.println("Fetching show by id "+showId);
        Show show = showService.getShowById(showId);
        return ResponseEntity.ok(
                ApiResponseDto.builder()
                        .message("Fetching Show with showId "+showId)
                        .data(show)
                        .build()
        );
    }

    @PostMapping("/show/create")
    public ResponseEntity<ApiResponseDto> createShow(@RequestBody ShowRequestDto showRequestDto) {
        System.out.println("Creating show");
        Show show = showService.createNewShow(showRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponseDto.builder()
                                .message("Created Show")
                                .data(show)
                                .build()
                );
    }

    @DeleteMapping("/show/delete/{showId}")
    public ResponseEntity<ApiResponseDto> deleteShowById(@PathVariable long showId) {
        System.out.println("Deleting show by Id");
        showService.deleteShowById(showId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
