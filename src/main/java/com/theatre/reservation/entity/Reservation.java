package com.theatre.reservation.entity;

import com.theatre.reservation.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    private User user;

    @ManyToOne
    @ToString.Exclude
    private Show show;

    @ManyToOne
    @ToString.Exclude
    List<Seat> seatsReserved;
    double amountPaid;

    @Enumerated(value = EnumType.STRING)
    private ReservationStatus reservationStatus;
    private LocalDateTime createdAt;
}
