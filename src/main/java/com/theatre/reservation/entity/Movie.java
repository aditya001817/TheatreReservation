package com.theatre.reservation.entity;

import com.theatre.reservation.enums.MovieGenre;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String movieName;
    private String movieLanguage;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    private List<MovieGenre> movieGenre;

    private LocalDate releaseDate;
    private int movieLength;
}
