package com.vybz.agreement_service.user_agreement.dto.request;

import com.vybz.agreement_service.user_agreement.vo.request.RequestDeleteUserAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteUserAgreementDto {

    private String userUuid;

    @Builder
    public RequestDeleteUserAgreementDto(String userUuid) {
        this.userUuid = userUuid;
    }

    public static RequestDeleteUserAgreementDto from(RequestDeleteUserAgreementVo requestDeleteUserAgreementVo) {
        return RequestDeleteUserAgreementDto.builder()
                .userUuid(requestDeleteUserAgreementVo.getUserUuid())
                .build();
    }

}
