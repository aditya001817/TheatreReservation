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
@Getter
@Setter

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long movieId;
    String movieName;
    String movieLanguage;

    @Enumerated(value = EnumType.STRING)
    List<MovieGenre> movieGenre;
    LocalDate releaseDate;
    int movieLength;

}
