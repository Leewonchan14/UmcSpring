package umc.spring.umcspring.Web.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.umcspring.ApiPayload.ApiResponse;
import umc.spring.umcspring.Converter.MemberMissionConvert;
import umc.spring.umcspring.Converter.MissionConverter;
import umc.spring.umcspring.Domain.Enum.MissionStatus;
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Domain.Mission;
import umc.spring.umcspring.Service.MemberMissionService.MemberMissionCommandService;
import umc.spring.umcspring.Service.MemberMissionService.MemberMissionQueryService;
import umc.spring.umcspring.Service.MissionService.MissionCommandService;
import umc.spring.umcspring.Validation.Annotation.*;
import umc.spring.umcspring.Web.Dto.MemberMissionRequestDTO;
import umc.spring.umcspring.Web.Dto.MemberMissionResponseDTO;
import umc.spring.umcspring.Web.Dto.MissionRequestDTO;
import umc.spring.umcspring.Web.Dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Validated
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    private final MemberMissionCommandService memberMissionCommandService;

    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping
    public ApiResponse<MemberMissionResponseDTO.AcceptResultDTO> acceptMission(
            @RequestBody @Valid @ExistMemberMission MemberMissionRequestDTO.AcceptDTO request
    ) {
        MemberMission newMemberMission = memberMissionCommandService.accept(request);

        return ApiResponse.onSuccess(MemberMissionConvert.toAcceptResultDTO(newMemberMission));
    }

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

    @Operation(summary = "내가 진행중인 미션 목록 API", description = "내가 진행중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page, status를 받습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!"),
            @Parameter(name = "status", description = "미션의 상태, query string 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, query string 입니다!")
    })
    @GetMapping("/members/{memberId}")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreViewListDTO> getMemberMissionList(
            @PathVariable @ExistMember Long memberId,
            @RequestParam(defaultValue = "CHALLENGING") MissionStatus status,
            @RequestParam(name = "page") Integer page
    ) {
        return ApiResponse.onSuccess(
                MemberMissionConvert.toMemberMissionPreViewListDTO(memberMissionQueryService.getMemberMissionList(memberId,status, page))
        );
    }

    @Operation(summary = "진행중인 미션 완료로 바꾸기 API", description = "진행중인 미션을 완료로 바꾸는 API입니다. 미션을 완료하면 리워드를 받을 수 있습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @PatchMapping
    public ApiResponse<MemberMissionResponseDTO.CompleteResultDTO> completeMission(
            @RequestBody @Valid @NotExistMemberMission @IsChallengingMission MemberMissionRequestDTO.CompleteDTO request
    ) {
        return ApiResponse.onSuccess(MemberMissionConvert.toCompleteResultDTO(
                memberMissionCommandService.complete(request)
        ));
    }
}
