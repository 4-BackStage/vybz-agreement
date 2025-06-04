package com.vybz.agreement_service.user_agreement.presentation;

import com.vybz.agreement_service.common.entity.BaseResponseEntity;
import com.vybz.agreement_service.common.entity.BaseResponseStatus;
import com.vybz.agreement_service.user_agreement.application.UserAgreementService;
import com.vybz.agreement_service.user_agreement.dto.request.RequestAddUserAgreementDto;
import com.vybz.agreement_service.user_agreement.dto.request.RequestDeleteUserAgreementDto;
import com.vybz.agreement_service.user_agreement.dto.request.RequestUpdateUserAgreementDto;
import com.vybz.agreement_service.user_agreement.dto.response.ResponseUserAgreementDto;
import com.vybz.agreement_service.user_agreement.vo.request.RequestAddUserAgreementVo;
import com.vybz.agreement_service.user_agreement.vo.request.RequestDeleteUserAgreementVo;
import com.vybz.agreement_service.user_agreement.vo.request.RequestUpdateUserAgreementVo;
import com.vybz.agreement_service.user_agreement.vo.response.ResponseUserAgreementVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-agreement")
public class UserAgreementController {

    private final UserAgreementService userAgreementService;

    /**
     * 유저 약관 동의 추가
     * @param requestAddUserAgreementVo
     */
    @Operation(summary = "유저 약관 동의 추가 API", description = "유저 약관 동의 추가 API 입니다.", tags = {"User-Agreement-Service"})
    @PostMapping
    public BaseResponseEntity<Void> createUserAgreement(@RequestBody RequestAddUserAgreementVo requestAddUserAgreementVo) {
        userAgreementService.createUserAgreement(RequestAddUserAgreementDto.from(requestAddUserAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 유저 UUID로 약관 동의 리스트 조회
     * @param userUuid
     */
    @Operation(summary = "유저 UUID로 약관 동의 리스트 조회 API", description = "유저 UUID로 약관 동의 리스트 조회 API 입니다.", tags = {"User-Agreement-Service"})
    @GetMapping("/list/{userUuid}")
    public BaseResponseEntity<List<ResponseUserAgreementVo>> getUserAgreementByUserUuid(@PathVariable("userUuid") String userUuid) {
        List<ResponseUserAgreementVo> responseUserAgreementVo = userAgreementService.getUserAgreementByUserUuid(userUuid)
                .stream()
                .map(ResponseUserAgreementDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseUserAgreementVo);
    }

    /**
     * 유저 약관 동의 수정
     * @param requestUpdateUserAgreementVo
     */
    @Operation(summary = "유저 약관 동의 수정 API", description = "유저 약관 동의 수정 API 입니다.", tags = {"User-Agreement-Service"})
    @PutMapping
    public BaseResponseEntity<Void> updateUserAgreement(@RequestBody RequestUpdateUserAgreementVo requestUpdateUserAgreementVo) {
        userAgreementService.updateUserAgreement(RequestUpdateUserAgreementDto.from(requestUpdateUserAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 유저 약관 동의 삭제
     * @param requestDeleteUserAgreementVo
     */
    @Operation(summary = "유저 약관 동의 삭제 API", description = "유저 약관 동의 삭제 API 입니다.", tags = {"User-Agreement-Service"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteUserAgreement(@RequestBody RequestDeleteUserAgreementVo requestDeleteUserAgreementVo) {
        userAgreementService.deleteUserAgreement(RequestDeleteUserAgreementDto.from(requestDeleteUserAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
