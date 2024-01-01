package umc.spring.umcspring.Service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.umcspring.Converter.MemberMissionConvert;
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Domain.Mission;
import umc.spring.umcspring.Repository.MemberMissionRepository;
import umc.spring.umcspring.Repository.MemberRepository;
import umc.spring.umcspring.Repository.MissionRepository;
import umc.spring.umcspring.Web.Dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;


    @Override
    public MemberMission accept(MemberMissionRequestDTO.AcceptDTO request) {
        Member findMember = memberRepository.findById(request.getMemberId()).get();
        Mission findMission = missionRepository.findById(request.getMissionId()).get();

        MemberMission newMemberMission = MemberMissionConvert.toMemberMission(request);

        newMemberMission.setMember(findMember);
        newMemberMission.setMission(findMission);

        return memberMissionRepository.save(newMemberMission);
    }
}
