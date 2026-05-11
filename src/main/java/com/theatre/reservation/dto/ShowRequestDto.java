package com.theatre.reservation.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShowRequestDto {
    private Long movieId;

    @JsonAlias("theatreId")
    private Long theaterId;

    private String startTime;
    private String endTime;
    private List<SeatStructure> seats;
}
