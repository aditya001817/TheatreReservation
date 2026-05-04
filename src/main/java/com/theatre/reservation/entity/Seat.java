package com.theatre.reservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.theatre.reservation.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seats")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private SeatStatus status;

    private double price;
    private int number;
    private String area;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
}