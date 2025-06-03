package com.vybz.agreement_service.user_agreement.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddUserAgreementVo {

    private String userUuid;
    private Long agreementId;
    private boolean agreed;

    @Builder
    public RequestAddUserAgreementVo(String userUuid, Long agreementId, boolean agreed) {
        this.userUuid = userUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

}
