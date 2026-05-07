package com.theatre.reservation.controller;

import com.theatre.reservation.dto.ApiResponseDto;
import com.theatre.reservation.dto.ReservationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    @GetMapping("/user/all")
    public ResponseEntity<ApiResponseDto> getAllReservationsForCurrentUser(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        System.out.println("Getting all reservations for current User ");
        return null;
    }

    @PostMapping("/reserve")
    public ResponseEntity<ApiResponseDto> createReservation(@RequestParam ReservationRequestDto reservationRequestDto) {
        System.out.println("Creating new Reservation");
        return null;
    }

    @GetMapping("/filter")
    public ResponseEntity<ApiResponseDto> filterReservation(@RequestParam(required = false) long movieId,
                                                            @RequestParam(required = false) long theaterId,
                                                            @RequestParam(required = false) long userId,
                                                            @RequestParam(defaultValue = "BOOKED") String reservationStatus,
                                                            @RequestParam(required = false) String createdDate) {
        System.out.println("Filtering Reservations ");
        return  null;
    }

    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity<ApiResponseDto> getReservationById(@PathVariable long reservationId) {
        System.out.println("Getting Reservation by id "+reservationId);
        return null;
    }

    @DeleteMapping("/cancel/{reservationId}")
    public ResponseEntity<ApiResponseDto> cancelReservation(@PathVariable long reservationId) {
        System.out.println("Canceling Reservation for ReservationId" +reservationId);
        return null;
    }
}
