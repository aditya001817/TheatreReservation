package com.theatre.reservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.theatre.reservation.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seats")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number;

    @Enumerated(value = EnumType.STRING)
    private SeatStatus status;

    private double price;
    private String area;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
}