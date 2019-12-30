package com.wemakeprice.junior.carpool.service.user;

import com.wemakeprice.junior.carpool.domain.user.User;
import com.wemakeprice.junior.carpool.domain.user.UserRepository;
import com.wemakeprice.junior.carpool.web.dto.UserResponseDto;
import com.wemakeprice.junior.carpool.web.dto.UserSaveRequestDto;
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
    public Long save(UserSaveRequestDto userSaveRequestDto) {
        return userRepository.save(userSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UserSaveRequestDto userSaveRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        user.update(userSaveRequestDto.getEmail(),
                userSaveRequestDto.getPassword(), userSaveRequestDto.getRole());
        return id;
    }

    @Transactional
    public UserResponseDto getUser(Long id) {
        return new UserResponseDto(userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id)));
    }

    @Transactional
    public List<UserResponseDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDto(user))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

//    @Transactional
//    public List<UserResponseDto> getUsers() {
//        return userRepository.findAll().stream()
//                .map(entity -> new UserResponseDto(entity))
//                .collect(Collectors.toList());
//    }
}
