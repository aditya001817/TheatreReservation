package com.theatre.reservation.controller;

import com.theatre.reservation.dto.ApiResponseDto;
import com.theatre.reservation.dto.ReservationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    public ResponseEntity<ApiResponseDto> getAllReservationsForCurrentUser(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        System.out.println("Getting all reservations for current User ");
        return null;
    }

    public ResponseEntity<ApiResponseDto> createReservation(@RequestParam ReservationRequestDto reservationRequestDto) {
        System.out.println("Creating new Reservation");
        return null;
    }
}
