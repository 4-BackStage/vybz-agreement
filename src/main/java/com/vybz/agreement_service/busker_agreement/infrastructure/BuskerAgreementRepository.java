package com.vybz.agreement_service.busker_agreement.infrastructure;

import com.vybz.agreement_service.busker_agreement.domain.BuskerAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuskerAgreementRepository extends JpaRepository<BuskerAgreement, Long> {

    /**
     * 버스커 uuid와 약관 id로 약관 동의 여부 조회
     * @param buskerUuid
     * @param agreementId
     */
    boolean existsByBuskerUuidAndAgreementId(String buskerUuid, Long agreementId);

    /**
     * 버스커 uuid와 약관 id로 약관 동의 조회
     * @param buskerUuid
     * @param agreementId
     */
    Optional<BuskerAgreement> findByBuskerUuidAndAgreementId(String buskerUuid, Long agreementId);

    /**
     * 버스커 uuid로 약관 동의 목록 조회
     * @param buskerUuid
     */
    List<BuskerAgreement> findAllByBuskerUuid(String buskerUuid);

}
