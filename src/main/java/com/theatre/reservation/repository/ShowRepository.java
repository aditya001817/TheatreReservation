package com.theatre.reservation.repository;

import com.theatre.reservation.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
