package com.theatre.reservation.exception;

import org.springframework.http.HttpStatus;

public class MovieNotFoundException extends CustomException{

    public MovieNotFoundException(String msg, HttpStatus status) {
        super(msg, status);
    }
}
