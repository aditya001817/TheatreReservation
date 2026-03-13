package com.theatre.reservation.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Remove;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "movie_movie_id")
    Movie movie;

    @ManyToOne
    Theater theater;
    LocalDateTime startTime;
    LocalDateTime endTime;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    List<Seat> seats;
}
