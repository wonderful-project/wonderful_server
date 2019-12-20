package com.wemakeprice.junior.carpool.web;

import com.wemakeprice.junior.carpool.domain.user.Role;
import com.wemakeprice.junior.carpool.domain.user.User;
import com.wemakeprice.junior.carpool.domain.user.UserRepository;
import com.wemakeprice.junior.carpool.service.user.UserService;
import com.wemakeprice.junior.carpool.web.dto.UserResponseDto;
import com.wemakeprice.junior.carpool.web.dto.UserSaveRequestDto;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @After
    void clear() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    void 회원가입() throws Exception {

        //given
        String email = "dummy@gmail.com";
        String password = "1234";
        Role role = Role.DRIVER;
        UserSaveRequestDto userSaveRequestDto =
                UserSaveRequestDto.builder()
                    .email(email)
                    .password(password)
                    .role(role).build();

        String url = "http://localhost:" + port + "/api/v1/user";

        //when
        ResponseEntity<Long> responseEntity =
                restTemplate.postForEntity(url, userSaveRequestDto, Long.class);

        //then
        List<User> userList =  userRepository.findAll();

        User user = userList.get(0);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPassword()).isEqualTo(password);
    }

    @Test
    void 회원정보수정() {
        //given
        String email = "dummy@gmail.com";
        String password = "1234";
        Role role = Role.DRIVER;
        UserSaveRequestDto userSaveRequestDto =
                UserSaveRequestDto.builder()
                        .email(email)
                        .password(password)
                        .role(role).build();

        Long userId = userRepository.save(userSaveRequestDto.toEntity()).getId();

        String newEmail = "test@naver.com";
        String newPassword = "0000";
        Role newRole = Role.PASSENGER;

        UserSaveRequestDto newUserSaveRequestDto =
                UserSaveRequestDto.builder()
                        .email(newEmail)
                        .password(newPassword)
                        .role(newRole).build();

        String url = "http://localhost:" + port + "/api/v1/user/" + userId;

        HttpEntity<UserSaveRequestDto> requestEntity = new HttpEntity<>(newUserSaveRequestDto);

        //when
        ResponseEntity<Long> responseEntity =
                restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        List<User> userList =  userRepository.findAll();

        User user = userList.get(0);
        assertThat(user.getEmail()).isEqualTo(newEmail);
        assertThat(user.getPassword()).isEqualTo(newPassword);
    }
}