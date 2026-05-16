package com.theatre.reservation.exception;

import org.springframework.http.HttpStatus;

public class AmountNotMatchedException extends CustomException {
    public AmountNotMatchedException(String message, HttpStatus status) {
        super(message, status);
    }
}
