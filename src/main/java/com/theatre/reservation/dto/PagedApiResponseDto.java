package com.theatre.reservation.dto;

import com.theatre.reservation.entity.Movie;
import org.springframework.http.HttpStatus;

import java.util.List;

public class PagedApiResponseDto {

    int totalPages;
    long totalElements;
    List<?> currentPageData;
    int currentCount;
}
