package com.vybz.agreement_service.agreement.vo.response;

import com.vybz.agreement_service.agreement.domain.AgreementType;
import com.vybz.agreement_service.agreement.domain.UserType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseAgreementVo {

    private Long id;
    private String title;
    private String content;
    private boolean required;
    private UserType userType;
    private AgreementType agreementType;

    @Builder
    public ResponseAgreementVo(Long id, String title, String content, boolean required, UserType userType, AgreementType agreementType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.required = required;
        this.userType = userType;
        this.agreementType = agreementType;
    }

}
