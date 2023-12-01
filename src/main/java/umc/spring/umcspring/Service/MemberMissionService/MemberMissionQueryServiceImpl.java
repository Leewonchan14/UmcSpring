package umc.spring.umcspring.Service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.umcspring.Repository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService{

    private final MemberMissionRepository memberMissionRepository;
    @Override
    public boolean isExist(Long memberId, Long missionId) {

        return memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);
    }
}
