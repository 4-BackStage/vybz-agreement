package com.vybz.agreement_service.kafka.consumer;

import com.vybz.agreement_service.busker_agreement.domain.BuskerAgreement;
import com.vybz.agreement_service.busker_agreement.infrastructure.BuskerAgreementRepository;
import com.vybz.agreement_service.kafka.event.BuskerAgreementEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BuskerAgreementEventConsumer {

    private final BuskerAgreementRepository buskerAgreementRepository;

    @KafkaListener(
            topics = "create-busker-auth",
            groupId = "busker-agreement-group",
            containerFactory = "buskerAgreementKafkaListenerContainerFactory")
    public void consumeBuskerAgreementEvent(BuskerAgreementEvent event) {
        log.info("🔥 Kafka 버스커 약관 동의 메시지 수신: {}", event);

        for (BuskerAgreementEvent.AgreementInfo agreement : event.getAgreements()) {
            boolean exists = buskerAgreementRepository.existsByBuskerUuidAndAgreementId(
                    event.getBuskerUuid(), agreement.getAgreementId());

            if (exists) {
                log.warn("🚫 이미 존재하는 동의: buskerUuid={}, agreementId={}",
                        event.getBuskerUuid(), agreement.getAgreementId());
                continue;
            }

            BuskerAgreement buskerAgreement = BuskerAgreement.builder()
                    .buskerUuid(event.getBuskerUuid())
                    .agreementId(agreement.getAgreementId())
                    .agreed(agreement.getAgreed())
                    .build();

            buskerAgreementRepository.save(buskerAgreement);
            log.info("✅ 약관 동의 저장 완료: {}", buskerAgreement);
        }
    }
}
