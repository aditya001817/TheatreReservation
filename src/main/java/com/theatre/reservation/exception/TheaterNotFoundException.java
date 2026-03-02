package com.theatre.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;

public class TheaterNotFoundException extends CustomException {

    public TheaterNotFoundException(String msg, HttpStatus status) {
//        super(msg, status);
    }
}
