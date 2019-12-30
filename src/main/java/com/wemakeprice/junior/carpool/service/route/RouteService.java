package com.wemakeprice.junior.carpool.service.route;

import com.wemakeprice.junior.carpool.domain.route.Route;
import com.wemakeprice.junior.carpool.domain.route.RouteRepository;
import com.wemakeprice.junior.carpool.domain.user.User;
import com.wemakeprice.junior.carpool.domain.user.UserRepository;
import com.wemakeprice.junior.carpool.web.dto.RouteResponseDto;
import com.wemakeprice.junior.carpool.web.dto.RouteSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(RouteSaveRequestDto routeSaveRequestDto) {
        User user = userRepository.findById(routeSaveRequestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + routeSaveRequestDto.getUserId()));
        Route route = routeSaveRequestDto.toEntity();
        route.updateUser(user);
        return routeRepository.save(route).getId();
    }

    @Transactional
    public Long update(Long id, RouteSaveRequestDto routeSaveRequestDto) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        route.update(routeSaveRequestDto.getOriginAddress(), routeSaveRequestDto.getOriginX(), routeSaveRequestDto.getOriginY(),
                routeSaveRequestDto.getDestinationAddress(), routeSaveRequestDto.getDestinationX(), routeSaveRequestDto.getDestinationY(),
                routeSaveRequestDto.getTimeOfDeparture());
        return id;
    }

    @Transactional
    public RouteResponseDto findById(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new RouteResponseDto(route);
    }

    @Transactional
    public List<RouteResponseDto> findAll() {
        return routeRepository.findAll()
                .stream()
                .map(route -> new RouteResponseDto(route))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        routeRepository.deleteById(id);
    }
}
