package com.wemakeprice.junior.carpool.web.dto;

import com.wemakeprice.junior.carpool.domain.route.Route;
import com.wemakeprice.junior.carpool.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RouteResponseDto {

    private Long id;
    private Long userId;
    private String origin;
    private String destination;
    private LocalDateTime timeOfDeparture;

    public RouteResponseDto(Route entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.origin = entity.getOriginAddress();
        this.destination = entity.getDestinationAddress();
        this.timeOfDeparture = entity.getTimeOfDeparture();
    }
}
