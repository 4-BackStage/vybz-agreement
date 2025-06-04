package com.vybz.agreement_service.agreement.domain;

import lombok.Getter;

@Getter
public enum UserType {

    USER("유저"),
    BUSKER("버스커");

    private final String description;

    UserType(String description) {
        this.description = description;
    }

}
