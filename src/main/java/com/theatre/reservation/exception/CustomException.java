package com.theatre.reservation.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomException extends RuntimeException{

    String message;
    HttpStatus httpStatus;

    public CustomException(String message, HttpStatus status) {
        this.message = message;
        this.httpStatus = status;
    }
}
