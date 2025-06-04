package com.vybz.agreement_service.agreement.dto.request;

import com.vybz.agreement_service.agreement.domain.Agreement;
import com.vybz.agreement_service.agreement.domain.AgreementType;
import com.vybz.agreement_service.agreement.domain.UserType;
import com.vybz.agreement_service.agreement.vo.request.RequestUpdateAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateAgreementDto {

    private String title;
    private String content;
    private boolean required;
    private UserType userType;
    private AgreementType agreementType;

    @Builder
    public RequestUpdateAgreementDto(String title, String content, boolean required, UserType userType, AgreementType agreementType) {
        this.title = title;
        this.content = content;
        this.required = required;
        this.userType = userType;
        this.agreementType = agreementType;
    }

    public Agreement updateEntity(Agreement agreement) {
        return Agreement.builder()
                .id(agreement.getId())
                .title(title)
                .content(content)
                .required(required)
                .userType(userType)
                .agreementType(agreementType)
                .build();
    }

    public static RequestUpdateAgreementDto from(RequestUpdateAgreementVo requestUpdateAgreementVo) {
        return RequestUpdateAgreementDto.builder()
                .title(requestUpdateAgreementVo.getTitle())
                .content(requestUpdateAgreementVo.getContent())
                .required(requestUpdateAgreementVo.isRequired())
                .agreementType(requestUpdateAgreementVo.getAgreementType())
                .build();
    }

}
