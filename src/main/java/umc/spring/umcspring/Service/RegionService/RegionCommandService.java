package umc.spring.umcspring.Service.RegionService;

import umc.spring.umcspring.Domain.Region;
import umc.spring.umcspring.Web.Dto.RegionRequestDTO;

public interface RegionCommandService {
     Region createRegion(RegionRequestDTO.CreateDTO request);
}
