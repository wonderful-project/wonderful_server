package com.wemakeprice.junior.carpool.web.dto;

import com.wemakeprice.junior.carpool.domain.user.Role;
import com.wemakeprice.junior.carpool.domain.user.User;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserResponseDto {

    private Long id;
    private String email;
    private String password;
    private Role role;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.role = entity.getRole();
    }
}
