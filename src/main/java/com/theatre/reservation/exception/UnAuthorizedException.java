package com.theatre.reservation.exception;

import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends CustomException {
    public UnAuthorizedException(String message, HttpStatus status) {
        super(message, status);
    }
}
