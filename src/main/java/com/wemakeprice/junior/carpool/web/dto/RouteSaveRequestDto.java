package com.wemakeprice.junior.carpool.web.dto;

import com.wemakeprice.junior.carpool.domain.route.Location;
import com.wemakeprice.junior.carpool.domain.route.Route;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
public class RouteSaveRequestDto {

    private Long userId;
    private String originAddress;
    private Double originX;
    private Double originY;
    private String destinationAddress;
    private Double destinationX;
    private Double destinationY;
    private LocalDateTime timeOfDeparture;

    public Location getOrigin() {
        return Location.builder()
                .address(originAddress)
                .x(originX)
                .y(originY)
                .build();
    }

    public Location getDestination() {
        return Location.builder()
                .address(destinationAddress)
                .x(destinationX)
                .y(destinationY)
                .build();
    }

    @Builder
    public RouteSaveRequestDto(Long userId, String originAddress, Double originX, Double originY,
                               String destinationAddress, Double destinationX, Double destinationY,
                               LocalDateTime timeOfDeparture) {
        this.userId = userId;
        this.originAddress = originAddress;
        this.originX = originX;
        this.originY = originY;
        this.destinationAddress = destinationAddress;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.timeOfDeparture = timeOfDeparture;
    }

    public Route toEntity() {
        return Route.builder()
                .origin(getOrigin())
                .destination(getDestination())
                .timeOfDeparture(timeOfDeparture)
                .build();
    }
}
