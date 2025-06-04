package com.vybz.agreement_service.busker_agreement.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddBuskerAgreementVo {

    private String buskerUuid;
    private Long agreementId;
    private boolean agreed;

    @Builder
    public RequestAddBuskerAgreementVo(String buskerUuid, Long agreementId, boolean agreed) {
        this.buskerUuid = buskerUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

}
