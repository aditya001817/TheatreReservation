package com.theatre.reservation.dto;

import com.theatre.reservation.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    long id;
    String firstName;
    String lastName;
    String username;
    String email;
    Role role;
}
