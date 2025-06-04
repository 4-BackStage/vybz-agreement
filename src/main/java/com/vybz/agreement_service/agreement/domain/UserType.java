package com.vybz.agreement_service.agreement.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserType {

    USER("유저"),
    BUSKER("버스커");

    private final String description;

}
