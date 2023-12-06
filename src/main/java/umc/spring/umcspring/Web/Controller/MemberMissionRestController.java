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
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Service.MemberMissionService.MemberMissionCommandService;
import umc.spring.umcspring.Service.MemberMissionService.MemberMissionQueryService;
import umc.spring.umcspring.Validation.Annotation.ExistMemberMission;
import umc.spring.umcspring.Web.Dto.MemberMissionRequestDTO;
import umc.spring.umcspring.Web.Dto.MemberMissionResponseDTO;
import umc.spring.umcspring.Web.Dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("memberMission")
@RequiredArgsConstructor
@Validated
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    private final MemberMissionQueryService memberMissionQueryService;
    @PostMapping
    public ApiResponse<MemberMissionResponseDTO.AcceptResultDTO> acceptMission(
            @RequestBody @Valid @ExistMemberMission MemberMissionRequestDTO.AcceptDTO request
    ) {
        MemberMission newMemberMission = memberMissionCommandService.accept(request);

        return ApiResponse.onSuccess(MemberMissionConvert.toAcceptResultDTO(newMemberMission));
    }

    @Operation(summary = "내가 진행중인 미션 목록 API", description = "내가 진행중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!")
    })
    @GetMapping("/members/{memberId}")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreViewListDTO> getMemberMissionList(
            @PathVariable Long memberId,
            @RequestParam(name = "page") Integer page
    ) {
        return ApiResponse.onSuccess(
                MemberMissionConvert.toMemberMissionPreViewListDTO(memberMissionQueryService.getMemberMissionList(memberId, page))
        );
    }
}
