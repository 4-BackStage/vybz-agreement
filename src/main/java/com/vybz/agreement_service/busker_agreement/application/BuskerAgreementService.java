package com.vybz.agreement_service.busker_agreement.application;

import com.vybz.agreement_service.busker_agreement.dto.request.RequestAddBuskerAgreementDto;
import com.vybz.agreement_service.busker_agreement.dto.request.RequestDeleteBuskerAgreementDto;
import com.vybz.agreement_service.busker_agreement.dto.request.RequestUpdateBuskerAgreementDto;
import com.vybz.agreement_service.busker_agreement.dto.response.ResponseBuskerAgreementDto;

import java.util.List;

public interface BuskerAgreementService {

    /**
     * 버스커 약관 동의 생성
     * @param requestAddBuskerAgreementDto
     */
    void createBuskerAgreement(RequestAddBuskerAgreementDto requestAddBuskerAgreementDto);

    /**
     * 버스커 uuid로 약관 동의 여부 리스트 조회
     * @param buskerUuid
     */
    List<ResponseBuskerAgreementDto> getUserAgreementByBuskerUuid(String buskerUuid);

    /**
     * 버스커 약관 동의 업데이트
     * @param requestUpdateBuskerAgreementDto
     */
    void updateBuskerAgreement(RequestUpdateBuskerAgreementDto requestUpdateBuskerAgreementDto);

    /**
     * 버스커 약관 동의 삭제
     * @param requestDeleteBuskerAgreementDto
     */
    void deleteBuskerAgreement(RequestDeleteBuskerAgreementDto requestDeleteBuskerAgreementDto);

}
