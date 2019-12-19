package com.wemakeprice.junior.carpool.web.dto;

import com.wemakeprice.junior.carpool.domain.route.Route;
import lombok.Builder;

import java.time.LocalDateTime;

public class RouteResponseDto {

    private Long id;
    private String origin;
    private String destination;
    private LocalDateTime timeOfDeparture;

    public RouteResponseDto(Route entity) {
        this.id = entity.getId();
        this.origin = entity.getOrigin();
        this.destination = entity.getDestination();
        this.timeOfDeparture = entity.getTimeOfDeparture();
    }
}
