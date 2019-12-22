package com.wemakeprice.junior.carpool.domain.route;

import com.wemakeprice.junior.carpool.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String originAddress;

    @Column(nullable = false)
    private Double originX;

    @Column(nullable = false)
    private Double originY;

    @Column(nullable = false)
    private String destinationAddress;

    @Column(nullable = false)
    private Double destinationX;

    @Column(nullable = false)
    private Double destinationY;

    @Column(nullable = false)
    private LocalDateTime timeOfDeparture;

    @Builder
    public Route(String originAddress, Double originX, Double originY,
                 String destinationAddress, Double destinationX, Double destinationY,
                 LocalDateTime timeOfDeparture) {
        this.originAddress = originAddress;
        this.originX = originX;
        this.originY = originY;
        this.destinationAddress = destinationAddress;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.timeOfDeparture = timeOfDeparture;
    }

    public void update(String originAddress, Double originX, Double originY,
                       String destinationAddress, Double destinationX, Double destinationY,
                       LocalDateTime timeOfDeparture) {
        this.originAddress = originAddress;
        this.originX = originX;
        this.originY = originY;
        this.destinationAddress = destinationAddress;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.timeOfDeparture = timeOfDeparture;
    }

    public void updateUser(User user) {
        this.user = user;
    }
}
