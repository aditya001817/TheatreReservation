package com.theatre.reservation.entity;

import com.theatre.reservation.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String email;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String username;


    private Role role;
    private String password;
}
