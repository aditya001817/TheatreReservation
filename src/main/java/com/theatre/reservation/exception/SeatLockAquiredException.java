package com.theatre.reservation.exception;

import org.springframework.http.HttpStatus;

public class SeatLockAquiredException extends CustomException {
    public SeatLockAquiredException(String message, HttpStatus status) {
        super(message,  status);
    }
}
