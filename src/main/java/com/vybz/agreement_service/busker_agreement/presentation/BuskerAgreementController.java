package com.vybz.agreement_service.busker_agreement.presentation;

import com.vybz.agreement_service.busker_agreement.application.BuskerAgreementService;
import com.vybz.agreement_service.busker_agreement.dto.request.RequestAddBuskerAgreementDto;
import com.vybz.agreement_service.busker_agreement.dto.request.RequestDeleteBuskerAgreementDto;
import com.vybz.agreement_service.busker_agreement.dto.request.RequestUpdateBuskerAgreementDto;
import com.vybz.agreement_service.busker_agreement.dto.response.ResponseBuskerAgreementDto;
import com.vybz.agreement_service.busker_agreement.vo.request.RequestAddBuskerAgreementVo;
import com.vybz.agreement_service.busker_agreement.vo.request.RequestDeleteBuskerAgreementVo;
import com.vybz.agreement_service.busker_agreement.vo.request.RequestUpdateBuskerAgreementVo;
import com.vybz.agreement_service.busker_agreement.vo.response.ResponseBuskerAgreementVo;
import com.vybz.agreement_service.common.entity.BaseResponseEntity;
import com.vybz.agreement_service.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/busker-agreement")
public class BuskerAgreementController {

    private final BuskerAgreementService buskerAgreementService;

    /**
     * 버스커 약관 동의 추가
     * @param requestAddBuskerAgreementVo
     */
    @Operation(summary = "버스커 약관 동의 추가 API", description = "버스커 약관 동의 추가 API 입니다.", tags = {"Busker-Agreement-Service"})
    @PostMapping
    public BaseResponseEntity<Void> createBuskerAgreement(@RequestBody RequestAddBuskerAgreementVo requestAddBuskerAgreementVo) {
        buskerAgreementService.createBuskerAgreement(RequestAddBuskerAgreementDto.from(requestAddBuskerAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 버스커 UUID로 약관 동의 리스트 조회
     * @param buskerUuid
     */
    @Operation(summary = "버스커 UUID로 약관 동의 리스트 조회 API", description = "버스커 UUID로 약관 동의 리스트 조회 API 입니다.", tags = {"Busker-Agreement-Service"})
    @GetMapping("/list/{buskerUuid}")
    public BaseResponseEntity<List<ResponseBuskerAgreementVo>> getBuskerAgreementByBuskerUuid(@PathVariable("buskerUuid") String buskerUuid) {
        List<ResponseBuskerAgreementVo> responseBuskerAgreementVo = buskerAgreementService.getUserAgreementByBuskerUuid(buskerUuid)
                .stream()
                .map(ResponseBuskerAgreementDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseBuskerAgreementVo);
    }

    /**
     * 버스커 약관 동의 수정
     *
     * @param requestUpdateBuskerAgreementVo
     */
    @Operation(summary = "버스커 약관 동의 수정 API", description = "버스커 약관 동의 수정 API 입니다.", tags = {"Busker-Agreement-Service"})
    @PutMapping
    public BaseResponseEntity<Void> updateBuskerAgreement(@RequestBody RequestUpdateBuskerAgreementVo requestUpdateBuskerAgreementVo) {
        buskerAgreementService.updateBuskerAgreement(RequestUpdateBuskerAgreementDto.from(requestUpdateBuskerAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 버스커 약관 동의 삭제
     *
     * @param requestDeleteBuskerAgreementVo
     */
    @Operation(summary = "버스커 약관 동의 삭제 API", description = "버스커 약관 동의 삭제 API 입니다.", tags = {"Busker-Agreement-Service"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteBuskerAgreement(@RequestBody RequestDeleteBuskerAgreementVo requestDeleteBuskerAgreementVo) {
        buskerAgreementService.deleteBuskerAgreement(RequestDeleteBuskerAgreementDto.from(requestDeleteBuskerAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
