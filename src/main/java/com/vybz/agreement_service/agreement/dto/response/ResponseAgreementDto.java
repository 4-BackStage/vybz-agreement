package com.vybz.agreement_service.agreement.dto.response;

import com.vybz.agreement_service.agreement.domain.Agreement;
import com.vybz.agreement_service.agreement.domain.AgreementType;
import com.vybz.agreement_service.agreement.domain.UserType;
import com.vybz.agreement_service.agreement.vo.response.ResponseAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseAgreementDto {

    private Long id;
    private String title;
    private String content;
    private boolean required;
    private UserType userType;
    private AgreementType agreementType;

    @Builder
    public ResponseAgreementDto(Long id, String title, String content, boolean required, UserType userType, AgreementType agreementType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.required = required;
        this.userType = userType;
        this.agreementType = agreementType;
    }

    public static ResponseAgreementDto from(Agreement agreement) {
        return ResponseAgreementDto.builder()
                .id(agreement.getId())
                .title(agreement.getTitle())
                .content(agreement.getContent())
                .required(agreement.getRequired())
                .userType(agreement.getUserType())
                .agreementType(agreement.getAgreementType())
                .build();
    }

    public ResponseAgreementVo toVo() {
        return ResponseAgreementVo.builder()
                .id(id)
                .title(title)
                .content(content)
                .required(required)
                .userType(userType)
                .agreementType(agreementType)
                .build();
    }

}
