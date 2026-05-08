package com.theatre.reservation.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Scope("Singleton")
public class SeatLockManager {

    private ConcurrentHashMap<Long, ReentrantLock> seatLocks = new ConcurrentHashMap<>();

    public
}
