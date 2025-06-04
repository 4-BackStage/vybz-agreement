package com.vybz.agreement_service.busker_agreement.dto.request;

import com.vybz.agreement_service.busker_agreement.domain.BuskerAgreement;
import com.vybz.agreement_service.busker_agreement.vo.request.RequestUpdateBuskerAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateBuskerAgreementDto {

    private String buskerUuid;
    private Long agreementId;
    private boolean agreed;

    @Builder
    public RequestUpdateBuskerAgreementDto(String buskerUuid, Long agreementId, boolean agreed) {
        this.buskerUuid = buskerUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

    public BuskerAgreement updateEntity(BuskerAgreement buskerAgreement) {
        return BuskerAgreement.builder()
                .id(buskerAgreement.getId())
                .buskerUuid(buskerUuid)
                .agreementId(agreementId)
                .agreed(agreed)
                .build();
    }

    public static RequestUpdateBuskerAgreementDto from(RequestUpdateBuskerAgreementVo requestUpdateBuskerAgreementVo) {
        return RequestUpdateBuskerAgreementDto.builder()
                .buskerUuid(requestUpdateBuskerAgreementVo.getBuskerUuid())
                .agreementId(requestUpdateBuskerAgreementVo.getAgreementId())
                .agreed(requestUpdateBuskerAgreementVo.isAgreed())
                .build();
    }

}
