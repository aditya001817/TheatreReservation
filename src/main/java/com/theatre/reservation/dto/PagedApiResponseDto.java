package com.theatre.reservation.dto;

import com.theatre.reservation.entity.Movie;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Data
public class PagedApiResponseDto {

    int totalPages;
    long totalElements;
    List<?> currentPageData;
    int currentCount;
}
