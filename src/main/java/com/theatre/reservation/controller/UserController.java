package com.theatre.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    public final UserRepository userRepository;

    @GetMapping("/user/me")
    public ResponseEntity<?> currentUser() {
        System.out.println("Getting current user");
        return null;
    }

    @Secured({"ROLE_SUPER_ADMIN"})
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        System.out.println("Getting all users");
        return null;
    }

    @Secured({"ROLE_SUPER_ADMIN"})
    @PutMapping("/promote/{username)")
    public ResponseEntity<?> promoteUserToAdmin(@PathVariable String username) {
        System.out.println("Promoting user "+username);
        return null;
    }
}
