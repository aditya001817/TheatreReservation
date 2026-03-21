package com.theatre.reservation.entity;


import com.theatre.reservation.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long userId;
    String firstName;
    String lastName;
    String username;
    String email;

    @Enumerated(EnumType.STRING)
    Role role;
    String password;
}
