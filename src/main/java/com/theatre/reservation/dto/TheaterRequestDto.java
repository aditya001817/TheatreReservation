package com.theatre.reservation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterRequestDto {

    String name;
    String location;
}
