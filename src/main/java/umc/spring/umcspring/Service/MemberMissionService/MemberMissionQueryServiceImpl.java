package umc.spring.umcspring.Service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.umcspring.Domain.Enum.MissionStatus;
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Repository.MemberMissionRepository;
import umc.spring.umcspring.Repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    private final MemberRepository memberRepository;

    @Override
    public boolean isExist(Long memberId, Long missionId) {

        return memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);
    }

    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, MissionStatus status, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        return memberMissionRepository.findByMemberAndStatus(member, status, PageRequest.of(page, 10));
    }
}
