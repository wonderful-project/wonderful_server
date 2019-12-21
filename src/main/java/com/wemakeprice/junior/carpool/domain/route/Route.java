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
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private LocalDateTime timeOfDeparture;

    @Builder
    public Route(String origin, String destination, LocalDateTime timeOfDeparture) {
        this.origin = origin;
        this.destination = destination;
        this.timeOfDeparture = timeOfDeparture;
    }

    public void update(String origin, String destination, LocalDateTime timeOfDeparture) {
        this.origin = origin;
        this.destination = destination;
        this.timeOfDeparture = timeOfDeparture;
    }

    public void updateUser(User user) {
        this.user = user;
    }
}
