package umc.spring.umcspring.Web.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.umcspring.ApiPayload.ApiResponse;
import umc.spring.umcspring.Converter.MemberConverter;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Service.MemberService.MemberCommandService;
import umc.spring.umcspring.Service.MemberService.MemberQueryService;
import umc.spring.umcspring.Web.Dto.MemberRequestDTO;
import umc.spring.umcspring.Web.Dto.MemberResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request) {

        Member member = memberCommandService.joinMember(request);

        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
