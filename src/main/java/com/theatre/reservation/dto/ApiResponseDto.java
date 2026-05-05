package com.theatre.reservation.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiResponseDto {

    private String message;
    private Object data;
}
