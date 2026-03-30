package com.theatre.reservation.service;

import com.theatre.reservation.entity.Seat;
import com.theatre.reservation.enums.SeatStatus;
import com.theatre.reservation.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> createSeatsWithGivenPrice(int seats, double price, String area){
        return IntStream.range(1, seats+1)
                .mapToObj(seatCount -> Seat.builder()
                        .number(seatCount)
                        .price(price)
                        .area(area)
//                        .status(SeatStatus.UNBOOKED)
                        .build()
                )
                .map(seatRepository::save)
                .toList();
    }
}
