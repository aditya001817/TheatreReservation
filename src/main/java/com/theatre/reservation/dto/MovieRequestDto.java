package com.theatre.reservation.dto;

import com.theatre.reservation.enums.MovieGenre;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovieRequestDto {

    String movieLanguage;
    int movieLength;
    String movieName;
    List<MovieGenre> movieGenre;
    String releaseDate;
}
