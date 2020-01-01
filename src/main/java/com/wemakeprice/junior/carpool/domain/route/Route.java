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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name="ORIGIN_ADDRESS")),
            @AttributeOverride(name = "x", column = @Column(name="ORIGIN_X")),
            @AttributeOverride(name = "y", column = @Column(name="ORIGIN_Y"))
    })
    private Location origin;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name="DESTINATION_ADDRESS")),
            @AttributeOverride(name = "x", column = @Column(name="DESTINATION_X")),
            @AttributeOverride(name = "y", column = @Column(name="DESTINATION_Y"))
    })
    private Location destination;

    @Column(nullable = false)
    private LocalDateTime timeOfDeparture;

    @Builder
    public Route(Location origin, Location destination, LocalDateTime timeOfDeparture) {
        this.origin = origin;
        this.destination = destination;
        this.timeOfDeparture = timeOfDeparture;
    }

    public void update(Location origin, Location destination, LocalDateTime timeOfDeparture) {
        this.origin = origin;
        this.destination = destination;
        this.timeOfDeparture = timeOfDeparture;
    }

    public void updateUser(User user) {
        this.user = user;
    }
}
