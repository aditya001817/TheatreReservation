package com.theatre.reservation.controller;

import com.theatre.reservation.dto.ApiResponseDto;
import com.theatre.reservation.dto.UserResponseDto;
import com.theatre.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    public final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/me")
    public ResponseEntity<UserResponseDto> currentUser() {
        System.out.println("Getting current user");
        return null;
    }

    @Secured({"ROLE_SUPER_ADMIN"})
    @GetMapping("/all")
    public ResponseEntity<ApiResponseDto> getAllUsers() {
        System.out.println("Getting all users");
        List<UserResponseDto> userResponseDtos = userRepository.findAll()
                .stream()
                .map(user -> UserResponseDto.builder()
                        .email(user.getEmail())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .username(user.getUsername())
                        .role(user.getRole())
                        .build()
                )
                .toList();
        return null;
    }

    @Secured({"ROLE_SUPER_ADMIN"})
    @PutMapping("/promote/{username)")
    public ResponseEntity<UserResponseDto> promoteUserToAdmin(@PathVariable String username) {
        System.out.println("Promoting user "+username);
        return null;
    }
}
