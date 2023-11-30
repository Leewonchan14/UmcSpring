package umc.spring.umcspring.Web.Controller;

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
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission(
            @PathVariable @ExistStore Long storeId,
            @RequestBody @Valid MissionRequestDTO.CreateMissionDTO request
    ) {
        Mission newMission = missionCommandService.createMission(storeId, request);

        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(newMission));
    }
}
