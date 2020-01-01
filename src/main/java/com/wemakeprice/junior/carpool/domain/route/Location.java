package com.wemakeprice.junior.carpool.domain.route;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@Embeddable
public class Location {

    private String address;
    private Double x;
    private Double y;

    @Builder
    public Location(String address, Double x, Double y) {
        this.address = address;
        this.x = x;
        this.y = y;
    }
}
