package com.wemakeprice.junior.carpool.web;

import com.wemakeprice.junior.carpool.domain.route.Route;
import com.wemakeprice.junior.carpool.domain.route.RouteRepository;
import com.wemakeprice.junior.carpool.domain.user.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RouteApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    UserRepository userRepository;

    @After
    void clear() throws Exception {
        routeRepository.deleteAll();
    }

    @Test
    void 루트등록() {
        //given
//        Route route = Route.builder()
//                        .origin("a")
//                        .destination("b")
//                        .timeOfDeparture(LocalDateTime.now())
//                        .build();
//        Long id = routeRepository.save(route).getId();
//        Route route = Route.builder()
//                        .origin("a")
//                        .destination("b")
//                        .timeOfDeparture(LocalDateTime.now())
//                        .build();
//        Long id = routeRepository.save(route).getId();

        //when
//        Route load = routeRepository.findById(id).get();
//        System.out.println(load.getUser().getId());

        //then
    }
}