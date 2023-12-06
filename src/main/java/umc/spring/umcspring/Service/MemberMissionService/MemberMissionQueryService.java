package umc.spring.umcspring.Service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.umcspring.Domain.Mapping.MemberMission;

public interface MemberMissionQueryService {
    boolean isExist(Long memberId, Long missionId);

    Page<MemberMission> getMemberMissionList(Long memberId, Integer page);
}
