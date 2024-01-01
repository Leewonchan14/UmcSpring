package umc.spring.umcspring.Service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.umcspring.Domain.Mission;
import umc.spring.umcspring.Web.Dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission createMission(Long storeId, MissionRequestDTO.MissionCreateDTO request);

    Page<Mission> getMissionList(Long storeId, Integer page);
}
