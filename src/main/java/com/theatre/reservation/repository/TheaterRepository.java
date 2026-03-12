package com.theatre.reservation.repository;

import com.theatre.reservation.entity.Theater;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.lang.ScopedValue;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    Page<Theater> findAllByLocation(String  location, Pageable pageable);
}
