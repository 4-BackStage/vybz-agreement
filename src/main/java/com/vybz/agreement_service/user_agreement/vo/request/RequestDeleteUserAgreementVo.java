package com.vybz.agreement_service.user_agreement.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteUserAgreementVo {

    private String userUuid;

    @Builder
    public RequestDeleteUserAgreementVo(String userUuid) {
        this.userUuid = userUuid;
    }

}
