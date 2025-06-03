package com.vybz.agreement_service.user_agreement.infrastructure;

import com.vybz.agreement_service.user_agreement.domain.UserAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAgreementRepository extends JpaRepository<UserAgreement, Long> {

    /**
     * 유저 uuid와 약관 id로 약관 동의 여부 조회
     * @param userUuid
     * @param agreementId
     */
    boolean existsByUserUuidAndAgreementId(String userUuid, Long agreementId);

    /**
     * 유저 uuid와 약관 id로 약관 동의 조회
     * @param userUuid
     * @param agreementId
     */
    Optional<UserAgreement> findByUserUuidAndAgreementId(String userUuid, Long agreementId);

    /**
     * 유저 uuid로 약관 동의 목록 조회
     * @param userUuid
     */
    List<UserAgreement> findAllByUserUuid(String userUuid);

}
