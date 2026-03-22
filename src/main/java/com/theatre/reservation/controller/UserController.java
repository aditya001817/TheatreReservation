package com.theatre.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/user/me")
    public ResponseEntity<?> currentUser() {
        System.out.println("Getting current user");
        return null;
    }

    public ResponseEntity<?> getAllUsers() {
        System.out.println("Getting all users");
        return null;
    }

    public ResponseEntity<?> promoteUserToAdmin(@PathVariable String username) {
        System.out.println("Promoting user "+username);
        return null;
    }
}
