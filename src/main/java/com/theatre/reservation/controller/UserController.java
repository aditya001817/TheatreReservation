package com.theatre.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    public ResponseEntity<?> currentUser() {
        System.out.println("Getting current user");
        return null;
    }
}
