package com.vybz.agreement_service.user_agreement.dto.request;

import com.vybz.agreement_service.user_agreement.domain.UserAgreement;
import com.vybz.agreement_service.user_agreement.vo.request.RequestUpdateUserAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateUserAgreementDto {

    private String userUuid;
    private Long agreementId;
    private boolean agreed;

    @Builder
    public RequestUpdateUserAgreementDto(String userUuid, Long agreementId, boolean agreed) {
        this.userUuid = userUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

    public UserAgreement updateEntity(UserAgreement userAgreement) {
        return UserAgreement.builder()
                .id(userAgreement.getId())
                .userUuid(userUuid)
                .agreementId(agreementId)
                .agreed(agreed)
                .build();
    }

    public static RequestUpdateUserAgreementDto from(RequestUpdateUserAgreementVo requestUpdateUserAgreementVo) {
        return RequestUpdateUserAgreementDto.builder()
                .userUuid(requestUpdateUserAgreementVo.getUserUuid())
                .agreementId(requestUpdateUserAgreementVo.getAgreementId())
                .agreed(requestUpdateUserAgreementVo.isAgreed())
                .build();
    }

}
