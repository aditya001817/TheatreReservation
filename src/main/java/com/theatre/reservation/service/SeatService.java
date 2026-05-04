package com.theatre.reservation.service;

import com.theatre.reservation.entity.Seat;
import com.theatre.reservation.enums.SeatStatus;
import com.theatre.reservation.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> createSeatsWithGivenPrice(int count, double price, String area){
        List<Seat> seats = new ArrayList<>();
        for(int i = 1; i <= count; i++) {
            seats.add(Seat.builder()
                    .number(i)
                    .area(area)
                    .price(price)
                    .status(SeatStatus.UNBOOKED)
                    .build()
            );
        }
        return seats;
    }
}
