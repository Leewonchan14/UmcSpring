package umc.spring.umcspring.Service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.umcspring.Converter.MemberMissionConvert;
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Domain.Mission;
import umc.spring.umcspring.Repository.MemberMissionRepository;
import umc.spring.umcspring.Repository.MemberRepository;
import umc.spring.umcspring.Repository.MissionRepository;
import umc.spring.umcspring.Web.Dto.MemberMissionRequestDTO;
import umc.spring.umcspring.Web.Dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;


    @Override
    @Transactional
    public MemberMission accept(MemberMissionRequestDTO.AcceptDTO request) {
        Member findMember = memberRepository.findById(request.getMemberId()).get();
        Mission findMission = missionRepository.findById(request.getMissionId()).get();

        MemberMission newMemberMission = MemberMissionConvert.toMemberMission(request);

        newMemberMission.setMember(findMember);
        newMemberMission.setMission(findMission);

        return memberMissionRepository.save(newMemberMission);
    }

    @Override
    @Transactional
    public MemberMission complete(MemberMissionRequestDTO.CompleteDTO request) {

        Member member = memberRepository.findById(request.getMemberId()).get();
        Mission mission = missionRepository.findById(request.getMissionId()).get();

        MemberMission memberMission = memberMissionRepository.findByMemberAndMission(member, mission).get();

        memberMission.complete();

        return memberMissionRepository.save(memberMission);
    }
}
