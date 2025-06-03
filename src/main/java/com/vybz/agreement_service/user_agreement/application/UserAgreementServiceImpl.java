package com.vybz.agreement_service.user_agreement.application;

import com.vybz.agreement_service.common.entity.BaseResponseStatus;
import com.vybz.agreement_service.common.exception.BaseException;
import com.vybz.agreement_service.user_agreement.domain.UserAgreement;
import com.vybz.agreement_service.user_agreement.dto.request.RequestAddUserAgreementDto;
import com.vybz.agreement_service.user_agreement.dto.request.RequestDeleteUserAgreementDto;
import com.vybz.agreement_service.user_agreement.dto.request.RequestUpdateUserAgreementDto;
import com.vybz.agreement_service.user_agreement.dto.response.ResponseUserAgreementDto;
import com.vybz.agreement_service.user_agreement.infrastructure.UserAgreementRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAgreementServiceImpl implements UserAgreementService {

    private final UserAgreementRepository userAgreementRepository;

    /**
     * 유저 약관 동의 추가
     * @param requestAddUserAgreementDto
     */
    @Transactional
    @Override
    public void createUserAgreement(RequestAddUserAgreementDto requestAddUserAgreementDto) {
        if(userAgreementRepository.existsByUserUuidAndAgreementId(requestAddUserAgreementDto.getUserUuid(), requestAddUserAgreementDto.getAgreementId())) {
            throw new BaseException(BaseResponseStatus.ALREADY_AGREED);
        }
        userAgreementRepository.save(requestAddUserAgreementDto.toEntity());
    }

    /**
     * 유저 UUID로 약관 동의 여부 조회
     * @param userUuid
     */
    @Override
    public List<ResponseUserAgreementDto> getUserAgreementByUserUuid(String userUuid) {
        return userAgreementRepository.findAllByUserUuid(userUuid)
                .stream()
                .map(ResponseUserAgreementDto::from)
                .toList();
    }

    /**
     * 유저 약관 동의 수정
     * @param requestUpdateUserAgreementDto
     */
    @Transactional
    @Override
    public void updateUserAgreement(RequestUpdateUserAgreementDto requestUpdateUserAgreementDto) {
        UserAgreement userAgreement = userAgreementRepository.findByUserUuidAndAgreementId(requestUpdateUserAgreementDto.getUserUuid(), requestUpdateUserAgreementDto.getAgreementId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_USER_AGREEMENT));
        userAgreementRepository.save(requestUpdateUserAgreementDto.updateEntity(userAgreement));
    }

    /**
     * 유저 약관 동의 삭제
     * @param requestDeleteUserAgreementDto
     */
    @Transactional
    @Override
    public void deleteUserAgreement(RequestDeleteUserAgreementDto requestDeleteUserAgreementDto) {
        List<UserAgreement> userAgreement = userAgreementRepository.findAllByUserUuid(requestDeleteUserAgreementDto.getUserUuid());
        if(userAgreement.isEmpty()) {
            throw new BaseException(BaseResponseStatus.NO_EXIST_USER_AGREEMENT);
        }
        userAgreementRepository.deleteAll(userAgreement);
    }

}
