package umc.spring.umcspring.Service.MemberMissionService;

import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Web.Dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission accept(MemberMissionRequestDTO.AcceptDTO request);
}
