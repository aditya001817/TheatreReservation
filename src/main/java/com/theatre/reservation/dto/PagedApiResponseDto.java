package com.theatre.reservation.dto;

import com.theatre.reservation.entity.Movie;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Data
public class PagedApiResponseDto {

    private int totalPages;
    private long totalElements;
    private List<?> currentPageData;
    private int currentCount;
}
