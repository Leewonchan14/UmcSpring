package umc.spring.umcspring.Service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.umcspring.Domain.Enum.MissionStatus;
import umc.spring.umcspring.Domain.Mapping.MemberMission;

public interface MemberMissionQueryService {
    boolean isExist(Long memberId, Long missionId);

    boolean isChallenging(Long memberId, Long missionId);

    Page<MemberMission> getMemberMissionList(Long memberId, MissionStatus status, Integer page);
}
