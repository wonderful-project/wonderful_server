package com.wemakeprice.junior.carpool.web;

import com.wemakeprice.junior.carpool.domain.route.Route;
import com.wemakeprice.junior.carpool.domain.route.RouteRepository;
import com.wemakeprice.junior.carpool.domain.user.User;
import com.wemakeprice.junior.carpool.domain.user.UserRepository;
import com.wemakeprice.junior.carpool.web.dto.RouteResponseDto;
import com.wemakeprice.junior.carpool.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RouteApiController {

    private final RouteRepository routeRepository;
    private final UserRepository userRepository;

    @PostMapping
    public Long save() {
        return null;
    }

    @GetMapping("/api/v1/route")
    public RouteResponseDto getRoute() {
        //given
        Route route = Route.builder()
                .originAddress("a")
                .destinationAddress("b")
                .originX(1.0)
                .originY(1.0)
                .destinationX(1.0)
                .destinationY(1.0)
                .timeOfDeparture(LocalDateTime.now())
                .build();
        User user = userRepository.findById(1L).get();
        route.updateUser(user);
        Long id = routeRepository.save(route).getId();

        return new RouteResponseDto(route);
    }

//    @GetMapping("/api/v1/users")
//    public List<UserResponseDto> getUser() {
//        return ;
//    }
}
