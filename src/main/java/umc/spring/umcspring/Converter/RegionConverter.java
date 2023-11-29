package umc.spring.umcspring.Converter;

import umc.spring.umcspring.Domain.Region;
import umc.spring.umcspring.Web.Dto.RegionRequestDTO;
import umc.spring.umcspring.Web.Dto.RegionResponseDTO;

public class RegionConverter {
    public static Region toRegion(RegionRequestDTO.CreateDTO request) {
        return Region.builder()
                .name(request.getName())
                .build();
    }

    public static RegionResponseDTO.CreateRegionResultDTO toRegionCreateResultDTO(Region region) {
        return RegionResponseDTO.CreateRegionResultDTO.builder()
                .regionId(region.getId())
                .createdAt(region.getCreatedAt())
                .build();
    }
}
