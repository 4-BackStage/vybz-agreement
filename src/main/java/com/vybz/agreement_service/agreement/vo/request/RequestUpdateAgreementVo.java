package com.vybz.agreement_service.agreement.vo.request;

import com.vybz.agreement_service.agreement.domain.AgreementType;
import com.vybz.agreement_service.agreement.domain.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateAgreementVo {

    private String title;
    private String content;
    private boolean required;
    private UserType userType;
    private AgreementType agreementType;

    @Builder
    public RequestUpdateAgreementVo(String title, String content, boolean required, UserType userType, AgreementType agreementType) {
        this.title = title;
        this.content = content;
        this.required = required;
        this.userType = userType;
        this.agreementType = agreementType;
    }

}
