package com.vybz.agreement_service.busker_agreement.dto.response;

import com.vybz.agreement_service.busker_agreement.domain.BuskerAgreement;
import com.vybz.agreement_service.busker_agreement.vo.response.ResponseBuskerAgreementVo;
import com.vybz.agreement_service.user_agreement.vo.response.ResponseUserAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseBuskerAgreementDto {

    private String buskerUuid;
    private Long agreementId;
    private boolean agreed;

    @Builder
    public ResponseBuskerAgreementDto(String buskerUuid, Long agreementId, boolean agreed) {
        this.buskerUuid = buskerUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

    public static ResponseBuskerAgreementDto from(BuskerAgreement buskerAgreement) {
        return ResponseBuskerAgreementDto.builder()
                .buskerUuid(buskerAgreement.getBuskerUuid())
                .agreementId(buskerAgreement.getAgreementId())
                .agreed(buskerAgreement.getAgreed())
                .build();
    }

    public ResponseBuskerAgreementVo toVo() {
        return ResponseBuskerAgreementVo.builder()
                .buskerUuid(buskerUuid)
                .agreementId(agreementId)
                .agreed(agreed)
                .build();
    }

}
