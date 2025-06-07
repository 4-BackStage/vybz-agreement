package com.vybz.agreement_service.kafka.event;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BuskerAgreementEvent {

    private String buskerUuid;
    private List<AgreementInfo> agreements;

    @Getter
    @NoArgsConstructor
    public static class AgreementInfo {
        private Long agreementId;
        private Boolean agreed;
    }

}
