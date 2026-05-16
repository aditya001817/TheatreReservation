package com.theatre.reservation.exception;

import org.springframework.http.HttpStatus;

public class SeatAlreadyBookedException extends CustomException {
    public SeatAlreadyBookedException(String message, HttpStatus status) {
        super(message,  status);
    }
}
