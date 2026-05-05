package com.theatre.reservation.dto;

import com.theatre.reservation.enums.MovieGenre;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovieRequestDto {

    private String movieLanguage;
    private int movieLength;
    private String movieName;
    private List<MovieGenre> movieGenre;
    private String releaseDate;
}
