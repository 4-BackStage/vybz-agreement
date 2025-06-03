package com.vybz.agreement_service.agreement.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteAgreementVo {

    private Long id;

    @Builder
    public RequestDeleteAgreementVo(Long id) {
        this.id = id;
    }

}
