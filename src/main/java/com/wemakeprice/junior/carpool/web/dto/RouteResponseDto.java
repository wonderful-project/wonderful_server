package com.wemakeprice.junior.carpool.web.dto;

import com.wemakeprice.junior.carpool.domain.route.Location;
import com.wemakeprice.junior.carpool.domain.route.Route;
import com.wemakeprice.junior.carpool.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RouteResponseDto {

    private Long id;
    private Long userId;
    private Location origin;
    private Location destination;
    private LocalDateTime timeOfDeparture;

    public RouteResponseDto(Route entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.origin = entity.getOrigin();
        this.destination = entity.getDestination();
        this.timeOfDeparture = entity.getTimeOfDeparture();
    }
}
