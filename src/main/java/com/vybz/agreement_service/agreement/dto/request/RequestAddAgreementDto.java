package com.vybz.agreement_service.agreement.dto.request;

import com.vybz.agreement_service.agreement.domain.Agreement;
import com.vybz.agreement_service.agreement.domain.AgreementType;
import com.vybz.agreement_service.agreement.domain.UserType;
import com.vybz.agreement_service.agreement.vo.request.RequestAddAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddAgreementDto {

    private String title;
    private String content;
    private boolean required;
    private UserType userType;
    private AgreementType agreementType;

    @Builder
    public RequestAddAgreementDto(String title, String content, boolean required, UserType userType, AgreementType agreementType) {
        this.title = title;
        this.content = content;
        this.required = required;
        this.userType = userType;
        this.agreementType = agreementType;
    }

    public Agreement toEntity() {
        return Agreement.builder()
                .title(title)
                .content(content)
                .required(required)
                .userType(userType)
                .agreementType(agreementType)
                .build();
    }

    public static RequestAddAgreementDto from(RequestAddAgreementVo requestAddAgreementVo) {
        return RequestAddAgreementDto.builder()
                .title(requestAddAgreementVo.getTitle())
                .content(requestAddAgreementVo.getContent())
                .required(requestAddAgreementVo.isRequired())
                .userType(requestAddAgreementVo.getUserType())
                .agreementType(requestAddAgreementVo.getAgreementType())
                .build();
    }

}
