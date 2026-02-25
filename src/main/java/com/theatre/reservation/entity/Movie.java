package com.theatre.reservation.entity;

import com.theatre.reservation.enums.MovieGenre;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;

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
    List<MovieGenre> movieGenre;
    LocalDate releaseDate;
    int movieLength;

}
