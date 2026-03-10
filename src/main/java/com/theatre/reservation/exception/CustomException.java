package com.theatre.reservation.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomException {

    String message;
    HttpStatus status;

    public CustomException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
