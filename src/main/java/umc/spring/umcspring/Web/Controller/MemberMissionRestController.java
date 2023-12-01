package umc.spring.umcspring.Web.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.umcspring.ApiPayload.ApiResponse;
import umc.spring.umcspring.Converter.MemberMissionConvert;
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Service.MemberMissionService.MemberMissionCommandService;
import umc.spring.umcspring.Validation.Annotation.ExistMemberMission;
import umc.spring.umcspring.Web.Dto.MemberMissionRequestDTO;
import umc.spring.umcspring.Web.Dto.MemberMissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("memberMission")
@RequiredArgsConstructor
@Validated
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;
    @PostMapping
    public ApiResponse<MemberMissionResponseDTO.AcceptResultDTO> acceptMission(
            @RequestBody @Valid @ExistMemberMission MemberMissionRequestDTO.AcceptDTO request
    ) {
        MemberMission newMemberMission = memberMissionCommandService.accept(request);

        return ApiResponse.onSuccess(MemberMissionConvert.toAcceptResultDTO(newMemberMission));
    }
}
