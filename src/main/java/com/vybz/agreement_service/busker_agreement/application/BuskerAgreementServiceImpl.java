package com.vybz.agreement_service.busker_agreement.application;

import com.vybz.agreement_service.busker_agreement.domain.BuskerAgreement;
import com.vybz.agreement_service.busker_agreement.dto.request.RequestAddBuskerAgreementDto;
import com.vybz.agreement_service.busker_agreement.dto.request.RequestDeleteBuskerAgreementDto;
import com.vybz.agreement_service.busker_agreement.dto.request.RequestUpdateBuskerAgreementDto;
import com.vybz.agreement_service.busker_agreement.dto.response.ResponseBuskerAgreementDto;
import com.vybz.agreement_service.busker_agreement.infrastructure.BuskerAgreementRepository;
import com.vybz.agreement_service.common.entity.BaseResponseStatus;
import com.vybz.agreement_service.common.exception.BaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuskerAgreementServiceImpl implements BuskerAgreementService {

    private final BuskerAgreementRepository buskerAgreementRepository;

    /**
     * 버스커 약관 동의 추가
     * @param requestAddBuskerAgreementDto
     */
    @Transactional
    @Override
    public void createBuskerAgreement(RequestAddBuskerAgreementDto requestAddBuskerAgreementDto) {
        if(buskerAgreementRepository.existsByBuskerUuidAndAgreementId(requestAddBuskerAgreementDto.getBuskerUuid(), requestAddBuskerAgreementDto.getAgreementId())) {
            throw new BaseException(BaseResponseStatus.ALREADY_AGREED);
        }
        buskerAgreementRepository.save(requestAddBuskerAgreementDto.toEntity());
    }

    /**
     * 버스커 UUID로 약관 동의 여부 조회
     *
     * @param buskerUuid
     */
    @Override
    public List<ResponseBuskerAgreementDto> getUserAgreementByBuskerUuid(String buskerUuid) {
        return buskerAgreementRepository.findAllByBuskerUuid(buskerUuid)
                .stream()
                .map(ResponseBuskerAgreementDto::from)
                .toList();
    }

    /**
     * 버스커 약관 동의 수정
     * @param requestUpdateBuskerAgreementDto
     */
    @Transactional
    @Override
    public void updateBuskerAgreement(RequestUpdateBuskerAgreementDto requestUpdateBuskerAgreementDto) {
        BuskerAgreement buskerAgreement = buskerAgreementRepository.findByBuskerUuidAndAgreementId(requestUpdateBuskerAgreementDto.getBuskerUuid(), requestUpdateBuskerAgreementDto.getAgreementId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_USER_AGREEMENT));
        buskerAgreementRepository.save(requestUpdateBuskerAgreementDto.updateEntity(buskerAgreement));
    }

    /**
     * 유저 약관 동의 삭제
     * @param requestDeleteBuskerAgreementDto
     */
    @Transactional
    @Override
    public void deleteBuskerAgreement(RequestDeleteBuskerAgreementDto requestDeleteBuskerAgreementDto) {
        List<BuskerAgreement> buskerAgreement = buskerAgreementRepository.findAllByBuskerUuid(requestDeleteBuskerAgreementDto.getBuskerUuid());
        if(buskerAgreement.isEmpty()) {
            throw new BaseException(BaseResponseStatus.NO_EXIST_USER_AGREEMENT);
        }
        buskerAgreementRepository.deleteAll(buskerAgreement);
    }

}
