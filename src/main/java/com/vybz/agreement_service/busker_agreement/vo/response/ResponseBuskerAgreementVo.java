package com.vybz.agreement_service.busker_agreement.vo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseBuskerAgreementVo {

    private String buskerUuid;
    private Long agreementId;
    private boolean agreed;

    @Builder
    public ResponseBuskerAgreementVo(String buskerUuid, Long agreementId, boolean agreed) {
        this.buskerUuid = buskerUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

}
