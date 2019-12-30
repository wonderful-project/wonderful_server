package com.wemakeprice.junior.carpool.web;

import com.wemakeprice.junior.carpool.domain.user.Role;
import com.wemakeprice.junior.carpool.service.user.UserService;
import com.wemakeprice.junior.carpool.web.dto.UserResponseDto;
import com.wemakeprice.junior.carpool.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        return userService.save(userSaveRequestDto);
    }

    @PutMapping("/api/v1/user/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserSaveRequestDto userSaveRequestDto) {
        return userService.update(id, userSaveRequestDto);
    }

    @GetMapping("/api/v1/user/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/api/v1/user")
    public List<UserResponseDto> getUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/api/v1/user/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/api/v1/user/add-dummies")
    public void addDummies() {
        for (int i = 0; i < 50; i++) {
            UserSaveRequestDto userSaveRequestDto = UserSaveRequestDto.builder()
                    .email("driver" + i + "@wemakeprice.com")
                    .password("0000")
                    .role(Role.DRIVER)
                    .build();
            UserSaveRequestDto userSaveRequestDto2 = UserSaveRequestDto.builder()
                    .email("passenger" + i + "@wemakeprice.com")
                    .password("0000")
                    .role(Role.PASSENGER)
                    .build();
            userService.save(userSaveRequestDto);
            userService.save(userSaveRequestDto2);
        }
    }
}
