package com.theatre.reservation.service;

import com.theatre.reservation.entity.Seat;
import com.theatre.reservation.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> createSeatWithGivenPrice(int seats, double price, String area){
        return null;
    }
}
