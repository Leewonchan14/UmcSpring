package umc.spring.umcspring.Converter;

import umc.spring.umcspring.Domain.Region;
import umc.spring.umcspring.Web.Dto.RegionRequestDTO;
import umc.spring.umcspring.Web.Dto.RegionResponseDTO;

public class RegionConverter {
    public static Region toRegion(RegionRequestDTO.RegionCreateDTO request) {
        return Region.builder()
                .name(request.getName())
                .build();
    }

    public static RegionResponseDTO.RegionCreateResultDTO toCreateRegionResultDTO(Region region) {
        return RegionResponseDTO.RegionCreateResultDTO.builder()
                .regionId(region.getId())
                .createdAt(region.getCreatedAt())
                .build();
    }
}
