package com.theatre.reservation.controller;

import com.theatre.reservation.dto.ApiResponseDto;
import com.theatre.reservation.dto.ReservationRequestDto;
import com.theatre.reservation.entity.Reservation;
import com.theatre.reservation.service.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/user/all")
    public ResponseEntity<ApiResponseDto> getAllReservationsForCurrentUser(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        System.out.println("Getting all reservations for current User ");
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Page<Reservation> reservations = getAllReservationsForCurrentUser(currentUsername, page, size);
        return ResponseEntity.ok(
                ApiResponseDto
                        .builder()
                        .message("All reservations for current User")
                        .data(reservations)
                        .build()
        );
    }

    @PostMapping("/reserve")
    public ResponseEntity<ApiResponseDto> createReservation(@RequestParam ReservationRequestDto reservationRequestDto) {
        System.out.println("Creating new Reservation");
        Reservation reservation = reservationService.createReservation(reservationRequestDto);
        return ResponseEntity.ok(
                ApiResponseDto.builder()
                        .message("Creating Reservation")
                        .data(reservation)
                        .build()
        );
    }

    @GetMapping("/filter")
    public ResponseEntity<ApiResponseDto> filterReservation(@RequestParam(required = false) long movieId,
                                                            @RequestParam(required = false) long theaterId,
                                                            @RequestParam(required = false) long userId,
                                                            @RequestParam(defaultValue = "BOOKED") String reservationStatus,
                                                            @RequestParam(required = false) String createdDate,
                                                            @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "5") int size) {
        System.out.println("Filtering Reservations ");
        Page<Reservation> filtered = reservationService.filterReservation(movieId, theaterId, userId, reservationStatus, createdDate, page, size);
        return  ResponseEntity.ok(
                ApiResponseDto.builder()
                        .message("Filtering Reservations")
                        .data(filtered)
                        .build()
        );
    }

    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity<ApiResponseDto> getReservationById(@PathVariable long reservationId) {
        System.out.println("Getting Reservation by id "+reservationId);
        String currentUsername = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reservation reservation = reservationService.getReservationById(currentUsername, reservationId);
        return ResponseEntity.ok(
                ApiResponseDto.builder()
                        .message("Fetching reservation for reservationId "+reservationId)
                        .data(reservation)
                        .build()
        );
    }

    @GetMapping("/reservation/{username}")
    public ResponseEntity<ApiResponseDto> getReservationById(@PathVariable String username,
                                                             @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "5") int size) {
        System.out.println("Getting Reservation by username "+username);
        Page<Reservation> reservation = reservationService.getReservationByUsername(username, page, size);
        return ResponseEntity.ok(
                ApiResponseDto.builder()
                        .message("Fetching reservation for username "+username)
                        .data(reservation)
                        .build()
        );
    }

    @DeleteMapping("/cancel/{reservationId}")
    public ResponseEntity<?> cancelReservation(@PathVariable long reservationId) {
        System.out.println("Canceling Reservation for ReservationId" +reservationId);
        reservationService.cancelReservation(reservationId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
