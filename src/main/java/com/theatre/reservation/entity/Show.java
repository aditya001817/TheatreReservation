package com.theatre.reservation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Movie.class)
    @JoinColumn(referencedColumnName = "movieId", nullable = false)
    private Movie movie;

    @ManyToOne
    private Theater theater;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    private List<Seat> seats;
}
