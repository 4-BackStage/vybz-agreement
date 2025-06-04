package com.vybz.agreement_service.busker_agreement.dto.request;

import com.vybz.agreement_service.busker_agreement.vo.request.RequestDeleteBuskerAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteBuskerAgreementDto {

    private String buskerUuid;

    @Builder
    public RequestDeleteBuskerAgreementDto(String buskerUuid) {
        this.buskerUuid = buskerUuid;
    }

    public static RequestDeleteBuskerAgreementDto from(RequestDeleteBuskerAgreementVo requestDeleteBuskerAgreementVo) {
        return RequestDeleteBuskerAgreementDto.builder()
                .buskerUuid(requestDeleteBuskerAgreementVo.getBuskerUuid())
                .build();
    }

}
