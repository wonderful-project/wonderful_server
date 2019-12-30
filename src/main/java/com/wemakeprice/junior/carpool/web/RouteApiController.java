package com.wemakeprice.junior.carpool.web;

import com.wemakeprice.junior.carpool.service.route.RouteService;
import com.wemakeprice.junior.carpool.web.dto.RouteResponseDto;
import com.wemakeprice.junior.carpool.web.dto.RouteSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class RouteApiController {

    private final RouteService routeService;

    @PostMapping("/api/v1/route")
    public Long save(@RequestBody RouteSaveRequestDto routeSaveRequestDto) {
        return routeService.save(routeSaveRequestDto);
    }

    @PutMapping("/api/v1/route/{id}")
    public Long update(@PathVariable Long id, @RequestBody RouteSaveRequestDto routeSaveRequestDto) {
        return routeService.update(id, routeSaveRequestDto);
    }

    @GetMapping("/api/v1/route/{id}")
    public RouteResponseDto getRoute(@PathVariable Long id) {
        return routeService.findById(id);
    }

    @DeleteMapping("/api/v1/route/{id}")
    public void delete(@PathVariable Long id) {
        routeService.delete(id);
    }

    @GetMapping("/api/v1/route")
    public List<RouteResponseDto> getRoutes() {
        return routeService.findAll();
    }

    @GetMapping("/api/v1/route/add-dummies")
    public void addDummies() {

        double centerY = 37.52319515;
        double centerX = 126.9811055;
        for (int i = 1; i < 100; i++) {
            double randomA = ((Math.random() * 10) / 3) / 100;
            double randomB = ((Math.random() * 10) / 3) / 100;
            double randomC = ((Math.random() * 10) / 3) / 100;
            double randomD = ((Math.random() * 10) / 3) / 100;
            RouteSaveRequestDto dto = RouteSaveRequestDto.builder()
                    .userId((long) i)
                    .originAddress("")
                    .originX(centerX + randomA)
                    .originY(centerY + randomB)
                    .destinationAddress("")
                    .destinationX(centerX + randomC)
                    .destinationY(centerY + randomD)
                    .timeOfDeparture(LocalDateTime.now()).build();

            save(dto);
        }
    }
}
