package umc.spring.umcspring.Web.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.umcspring.ApiPayload.ApiResponse;
import umc.spring.umcspring.Converter.RegionConverter;
import umc.spring.umcspring.Domain.Region;
import umc.spring.umcspring.Service.RegionService.RegionCommandService;
import umc.spring.umcspring.Web.Dto.RegionRequestDTO;
import umc.spring.umcspring.Web.Dto.RegionResponseDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("regions")
@RequiredArgsConstructor
public class RegionRestController {
    private final RegionCommandService regionCommandService;

    @PostMapping("/")
    public ApiResponse<RegionResponseDTO.CreateRegionResultDTO> createRegion(@RequestBody @Valid RegionRequestDTO.CreateDTO request){
        Region region = regionCommandService.createRegion(request);
        return ApiResponse.onSuccess(RegionConverter.toRegionCreateResultDTO(region));
    }
}
