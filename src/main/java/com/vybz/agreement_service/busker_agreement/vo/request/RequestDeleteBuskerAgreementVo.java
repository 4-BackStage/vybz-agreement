package com.vybz.agreement_service.busker_agreement.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteBuskerAgreementVo {

    private String buskerUuid;

    @Builder
    public RequestDeleteBuskerAgreementVo(String buskerUuid) {
        this.buskerUuid = buskerUuid;
    }

}
