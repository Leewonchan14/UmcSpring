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
import umc.spring.umcspring.Domain.Enum.MissionStatus;
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


}
