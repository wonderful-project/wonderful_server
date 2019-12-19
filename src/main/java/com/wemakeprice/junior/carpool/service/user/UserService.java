package com.wemakeprice.junior.carpool.service.user;

import com.wemakeprice.junior.carpool.domain.user.UserRepository;
import com.wemakeprice.junior.carpool.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save() {
        return 0L;
    }

//    @Transactional
//    public List<UserResponseDto> getUsers() {
//        return userRepository.findAll().stream()
//                .map(entity -> new UserResponseDto(entity))
//                .collect(Collectors.toList());
//    }
}
