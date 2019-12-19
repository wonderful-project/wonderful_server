package com.wemakeprice.junior.carpool.web.dto;

import com.wemakeprice.junior.carpool.domain.route.Route;
import lombok.Builder;

import java.time.LocalDateTime;

public class RouteSaveRequestDto {

    private String origin;
    private String destination;
    private LocalDateTime timeOfDeparture;

    @Builder
    public RouteSaveRequestDto(String origin, String destination, LocalDateTime timeOfDeparture) {
        this.origin = origin;
        this.destination = destination;
        this.timeOfDeparture = timeOfDeparture;
    }

    public Route toEntity() {
        return Route.builder()
                .origin(origin)
                .destination(destination)
                .timeOfDeparture(timeOfDeparture)
                .build();
    }
}
