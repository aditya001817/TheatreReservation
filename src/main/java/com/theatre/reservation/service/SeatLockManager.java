package com.theatre.reservation.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class SeatLockManager {

    private ConcurrentHashMap<Long, ReentrantLock> seatLocks = new ConcurrentHashMap<>();

    public ReentrantLock getLockForSeat(long seatId) {
        return seatLocks.computeIfAbsent(seatId , id -> new ReentrantLock());
    }

    public void releaseLockForSeat(long seatId) {
        seatLocks.remove(seatId);
    }
}
