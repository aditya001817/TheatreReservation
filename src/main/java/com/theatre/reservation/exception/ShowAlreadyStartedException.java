package com.theatre.reservation.exception;

import org.springframework.http.HttpStatus;

public class ShowAlreadyStartedException extends CustomException {
    public ShowAlreadyStartedException(String message, HttpStatus status) {
        super(message, status);
    }
}
