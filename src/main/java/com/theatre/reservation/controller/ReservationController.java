package com.theatre.reservation.controller;

import com.theatre.reservation.dto.ApiResponseDto;
import com.theatre.reservation.dto.ReservationRequestDto;
import com.theatre.reservation.entity.Reservation;
import com.theatre.reservation.entity.User;
import com.theatre.reservation.repository.UserRepository;
import com.theatre.reservation.service.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final UserRepository userRepository;

    public ReservationController(ReservationService reservationService, UserRepository userRepository) {
        this.reservationService = reservationService;
        this.userRepository = userRepository;
    }

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
