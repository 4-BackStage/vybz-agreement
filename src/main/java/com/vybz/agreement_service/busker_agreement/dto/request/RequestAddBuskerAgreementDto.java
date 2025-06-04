package com.vybz.agreement_service.busker_agreement.dto.request;

import com.vybz.agreement_service.busker_agreement.domain.BuskerAgreement;
import com.vybz.agreement_service.busker_agreement.vo.request.RequestAddBuskerAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddBuskerAgreementDto {

    private String buskerUuid;
    private Long agreementId;
    private boolean agreed;

    @Builder
    public RequestAddBuskerAgreementDto(String buskerUuid, Long agreementId, boolean agreed) {
        this.buskerUuid = buskerUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

    public BuskerAgreement toEntity() {
        return BuskerAgreement.builder()
                .buskerUuid(buskerUuid)
                .agreementId(agreementId)
                .agreed(agreed)
                .build();
    }

    public static RequestAddBuskerAgreementDto from(RequestAddBuskerAgreementVo requestAddBuskerAgreementVo) {
        return RequestAddBuskerAgreementDto.builder()
                .buskerUuid(requestAddBuskerAgreementVo.getBuskerUuid())
                .agreementId(requestAddBuskerAgreementVo.getAgreementId())
                .agreed(requestAddBuskerAgreementVo.isAgreed())
                .build();
    }

}
