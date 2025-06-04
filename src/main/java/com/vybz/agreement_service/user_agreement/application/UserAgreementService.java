package com.vybz.agreement_service.user_agreement.application;

import com.vybz.agreement_service.user_agreement.dto.request.RequestAddUserAgreementDto;
import com.vybz.agreement_service.user_agreement.dto.request.RequestDeleteUserAgreementDto;
import com.vybz.agreement_service.user_agreement.dto.request.RequestUpdateUserAgreementDto;
import com.vybz.agreement_service.user_agreement.dto.response.ResponseUserAgreementDto;

import java.util.List;

public interface UserAgreementService {

    /**
     * 유저 약관 동의 생성
     * @param requestAddUserAgreementDto
     */
    void createUserAgreement(RequestAddUserAgreementDto requestAddUserAgreementDto);

    /**
     * 유저 uuid로 약관 동의 여부 리스트 조회
     * @param userUuid
     */
    List<ResponseUserAgreementDto> getUserAgreementByUserUuid(String userUuid);

    /**
     * 유저 약관 동의 업데이트
     * @param requestUpdateUserAgreementDto
     */
    void updateUserAgreement(RequestUpdateUserAgreementDto requestUpdateUserAgreementDto);

    /**
     * 유저 약관 동의 삭제
     * @param requestDeleteUserAgreementDto
     */
    void deleteUserAgreement(RequestDeleteUserAgreementDto requestDeleteUserAgreementDto);

}
