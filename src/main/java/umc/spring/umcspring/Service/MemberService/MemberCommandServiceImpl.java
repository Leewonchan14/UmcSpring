package umc.spring.umcspring.Service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.umcspring.ApiPayload.Code.Status.ErrorStatus;
import umc.spring.umcspring.ApiPayload.Exception.Handler.FoodCategoryHandler;
import umc.spring.umcspring.ApiPayload.Exception.Handler.MemberMissionHandler;
import umc.spring.umcspring.Converter.MemberConverter;
import umc.spring.umcspring.Converter.MemberPreferConverter;
import umc.spring.umcspring.Domain.Enum.MissionStatus;
import umc.spring.umcspring.Domain.FoodCategory;
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Domain.Mapping.MemberPrefer;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Domain.Mission;
import umc.spring.umcspring.Repository.FoodCategoryRepository;
import umc.spring.umcspring.Repository.MemberMissionRepository;
import umc.spring.umcspring.Repository.MemberRepository;
import umc.spring.umcspring.Repository.MissionRepository;
import umc.spring.umcspring.Web.Dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category)
                            .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public MemberMission acceptMission(Long memberId, Long missionId) {
        // 멤버와 미션 찾기
        Member findMember = memberRepository.findById(memberId).get();

        // 미션 찾기
        Mission findMission = missionRepository.findById(missionId).get();

        // 이미 미션을 수락했는지 확인
        memberMissionRepository.findAllByMemberIdAndMissionId(memberId, missionId)
                .ifPresent(memberMission -> {
                    throw new MemberMissionHandler(ErrorStatus.MISSION_ALREADY_EXIST);
                });


        // 미션 수락
        MemberMission newMemberMission = MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();


        // 미션과 멤버 연결
        newMemberMission.setMission(findMission);
        // 멤버와 미션 연결
        newMemberMission.setMember(findMember);

        // 미션 저장
        return memberMissionRepository.save(newMemberMission);
    }
}
