package com.vybz.agreement_service.agreement.domain;

import com.vybz.agreement_service.common.entity.SoftDeletableEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "agreement")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Agreement extends SoftDeletableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  /**
     * 약관 제목
     */

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    /**
     * 약관 내용
     */
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    /**
     * 필수 여부
     */
    @Column(name = "required", nullable = false)
    private Boolean required;

    /**
     * 약관 대상
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType;

   /**
     * 약관 종류
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "agreement_type", nullable = false)
    private AgreementType agreementType;

    @Builder
    public Agreement(Long id, String title, String content, Boolean required, UserType userType, AgreementType agreementType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.required = required;
        this.userType = userType;
        this.agreementType = agreementType;
    }

}
