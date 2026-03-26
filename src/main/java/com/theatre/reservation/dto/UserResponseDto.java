package com.theatre.reservation.dto;

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
}
