package com.wemakeprice.junior.carpool.web.dto;

import com.wemakeprice.junior.carpool.domain.user.Role;
import com.wemakeprice.junior.carpool.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String email;
    private String password;
    private Role role;

    @Builder
    public UserSaveRequestDto(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .role(role)
                .build();
    }
}
