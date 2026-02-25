package com.theatre.reservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

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
//    List<MovieGenre> movieGenre;
    LocalDate releaseDate;
    int movieLength;

}
