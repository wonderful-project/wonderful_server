package com.wemakeprice.junior.carpool.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    ADMIN("ROLE_ADMIN","운영자"),
    DRIVER("ROLE_DRIVER", "운전자"),
    PASSENGER("ROLE_PASSENGER", "승객");

    private final String key;
    private final String title;
}
