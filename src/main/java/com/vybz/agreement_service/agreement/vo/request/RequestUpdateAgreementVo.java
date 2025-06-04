package com.vybz.agreement_service.agreement.vo.request;

import com.vybz.agreement_service.agreement.domain.AgreementType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateAgreementVo {

    private String title;
    private String content;
    private boolean required;
    private AgreementType agreementType;

    @Builder
    public RequestUpdateAgreementVo(String title, String content, boolean required, AgreementType agreementType) {
        this.title = title;
        this.content = content;
        this.required = required;
        this.agreementType = agreementType;
    }

}
