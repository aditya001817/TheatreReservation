package com.theatre.reservation.exception;

import org.springframework.http.HttpStatus;

public class ShowNotFoundException extends CustomException{
    public ShowNotFoundException(String message, HttpStatus status) {
        super(message, status);
    }
}
