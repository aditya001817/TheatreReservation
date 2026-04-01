package com.theatre.reservation.entity;

import com.theatre.reservation.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    int number;
    String area;
    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    SeatStatus status = SeatStatus.UNBOOKED;
    double price;
}
