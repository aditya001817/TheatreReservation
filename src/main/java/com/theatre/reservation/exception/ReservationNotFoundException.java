package com.theatre.reservation.exception;

import org.springframework.http.HttpStatus;

public class ReservationNotFoundException extends CustomException {
    public ReservationNotFoundException(String message, HttpStatus status) {
        super(message, status);
    }
}
