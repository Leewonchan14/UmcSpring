package umc.spring.umcspring.Service.MissionService;

import umc.spring.umcspring.Domain.Mission;
import umc.spring.umcspring.Web.Dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission createMission(Long storeId, MissionRequestDTO.MissionCreateDTO request);
}
