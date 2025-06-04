package com.vybz.agreement_service.busker_agreement.domain;

import com.vybz.agreement_service.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "busker_agreement")
public class BuskerAgreement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 회원 UUID
     */
    @Column(name = "busker_uuid", nullable = false)
    private String buskerUuid;

    /**
     * 약관 id
     */
    @JoinColumn(name = "agreement_id", nullable = false)
    private Long agreementId;

    /**
     * 약관 동의 여부
     */
    @Column(name = "agreed", nullable = false)
    private Boolean agreed;

    @Builder
    public BuskerAgreement(Long id, String buskerUuid, Long agreementId, Boolean agreed) {
        this.id = id;
        this.buskerUuid = buskerUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

}
