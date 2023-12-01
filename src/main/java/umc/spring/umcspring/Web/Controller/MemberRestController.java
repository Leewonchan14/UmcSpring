package umc.spring.umcspring.Web.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.umcspring.ApiPayload.ApiResponse;
import umc.spring.umcspring.Converter.MemberConverter;
import umc.spring.umcspring.Converter.MemberMissionConvert;
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Service.MemberService.MemberCommandService;
import umc.spring.umcspring.Validation.Annotation.ExistMember;
import umc.spring.umcspring.Validation.Annotation.ExistMission;
import umc.spring.umcspring.Web.Dto.MemberRequestDTO;
import umc.spring.umcspring.Web.Dto.MemberResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("members")
@Validated
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request) {

        Member member = memberCommandService.joinMember(request);

        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/{memberId}/missions/{missionId}")
    public ApiResponse<MemberResponseDTO.MemberMissionAcceptResultDTO> acceptMission(
            @PathVariable @ExistMember Long memberId,
            @PathVariable @ExistMission Long missionId
    ) {
        MemberMission newMemberMission = memberCommandService.acceptMission(memberId, missionId);

        return ApiResponse.onSuccess(MemberMissionConvert.toAcceptMemberMissionResultDTO(newMemberMission));
    }
}
