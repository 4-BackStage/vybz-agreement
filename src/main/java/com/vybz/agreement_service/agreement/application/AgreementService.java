package com.vybz.agreement_service.agreement.application;

import com.vybz.agreement_service.agreement.domain.AgreementType;
import com.vybz.agreement_service.agreement.domain.UserType;
import com.vybz.agreement_service.agreement.dto.request.RequestAddAgreementDto;
import com.vybz.agreement_service.agreement.dto.request.RequestDeleteAgreementDto;
import com.vybz.agreement_service.agreement.dto.request.RequestUpdateAgreementDto;
import com.vybz.agreement_service.agreement.dto.response.ResponseAgreementDto;

import java.util.List;

public interface AgreementService {

    /**
     * 약관 생성
     * @param requestAddAgreementDto
     */
    void createAgreement(RequestAddAgreementDto requestAddAgreementDto);

    /**
     * 약관 제목으로 약관 조회
     * @param title
     */
    ResponseAgreementDto getAgreementByTitle(String title);

    /**
     * 유저 타입으로 약관 리스트 조회
     * @param userType
     */
    List<ResponseAgreementDto> getAgreementsByUserType(UserType userType);

    /**
     * 약관 타입으로 약관 리스트 조회
     * @param agreementType
     */
    List<ResponseAgreementDto> getAgreementsByType(AgreementType agreementType);

    /**
     * 모든 약관 조회
     */
    List<ResponseAgreementDto> getAllAgreement();

    /**
     * 약관 수정
     * @param requestUpdateAgreementDto
     */
    void updateAgreement(RequestUpdateAgreementDto requestUpdateAgreementDto);

    /**
     * 약관 삭제
     * @param requestDeleteAgreementDto
     */
    void deleteAgreement(RequestDeleteAgreementDto requestDeleteAgreementDto);

}
