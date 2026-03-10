package com.theatre.reservation.exception;

import org.springframework.http.HttpStatus;

public class CustomException {

    String message;
    HttpStatus status;

    public CustomException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
