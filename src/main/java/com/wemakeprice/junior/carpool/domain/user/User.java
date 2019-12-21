package com.wemakeprice.junior.carpool.domain.user;

import com.wemakeprice.junior.carpool.domain.route.Route;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 30, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Route> routes = new ArrayList<>();

    @Builder
    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void update(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void addRoute(Route route) {
        this.routes.add(route);
        route.updateUser(this);
    }

    public void removeRoute(Route route) {
        this.routes.remove(route);
        route.updateUser(null);
    }
}
