package com.wemakeprice.junior.carpool.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RouteController {

    @GetMapping("/api/v1/user")
    public String getUser() {
        return "hello!";
    }
}
