package com.theatre.reservation.dto;

import com.theatre.reservation.entity.Seat;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShowRequestDto {
    long movieId;
    long theaterId;
    String startTime;
    String endTime;
    List<SeatStructure> seats;
}
