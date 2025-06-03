package com.vybz.agreement_service.user_agreement.dto.response;

import com.vybz.agreement_service.user_agreement.domain.UserAgreement;
import com.vybz.agreement_service.user_agreement.vo.response.ResponseUserAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseUserAgreementDto {

    private String userUuid;
    private Long agreementId;
    private boolean agreed;

    @Builder
    public ResponseUserAgreementDto(String userUuid, Long agreementId, boolean agreed) {
        this.userUuid = userUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

    public static ResponseUserAgreementDto from(UserAgreement userAgreement) {
        return ResponseUserAgreementDto.builder()
                .userUuid(userAgreement.getUserUuid())
                .agreementId(userAgreement.getAgreementId())
                .agreed(userAgreement.getAgreed())
                .build();
    }

    public ResponseUserAgreementVo toVo() {
        return ResponseUserAgreementVo.builder()
                .userUuid(userUuid)
                .agreementId(agreementId)
                .agreed(agreed)
                .build();
    }

}
