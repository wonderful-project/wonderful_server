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
    private String originAddress;
    private Double originX;
    private Double originY;
    private String destinationAddress;
    private Double destinationX;
    private Double destinationY;
    private LocalDateTime timeOfDeparture;

    public RouteResponseDto(Route entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.originAddress = entity.getOrigin().getAddress();
        this.originX = entity.getOrigin().getX();
        this.originY = entity.getOrigin().getY();
        this.destinationAddress = entity.getDestination().getAddress();
        this.destinationX = entity.getDestination().getX();
        this.destinationY = entity.getDestination().getY();
        this.timeOfDeparture = entity.getTimeOfDeparture();
    }
}
