package umc.spring.umcspring.Web.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.umcspring.ApiPayload.ApiResponse;
import umc.spring.umcspring.Converter.MissionConverter;
import umc.spring.umcspring.Domain.Mission;
import umc.spring.umcspring.Service.MissionService.MissionCommandService;
import umc.spring.umcspring.Validation.Annotation.ExistStore;
import umc.spring.umcspring.Web.Dto.MissionRequestDTO;
import umc.spring.umcspring.Web.Dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Validated
public class MissioniRestController {
    private final MissionCommandService missionCommandService;
    @PostMapping("/stores/{storeId}")
    public ApiResponse<MissionResponseDTO.MissionCreateResultDTO> createMission(
            @PathVariable @ExistStore Long storeId,
            @RequestBody @Valid MissionRequestDTO.MissionCreateDTO request
    ) {
        Mission newMission = missionCommandService.createMission(storeId, request);

        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(newMission));
    }

    @Operation(summary = "특정 가게의 미션 목록 API", description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
    })
    @GetMapping("stores/{storeId}")
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMissionList(
            @PathVariable @ExistStore Long storeId,
            @RequestParam(name = "page") Integer page
    ) {
        return ApiResponse.onSuccess(
                MissionConverter.toMissionPreViewListDTO(missionCommandService.getMissionList(storeId, page))
        );
    }
}
