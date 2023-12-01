package umc.spring.umcspring.Converter;

import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Web.Dto.MemberResponseDTO;

public class MemberMissionConvert {
    public static MemberResponseDTO.MemberMissionAcceptResultDTO toAcceptMemberMissionResultDTO(MemberMission memberMission) {
        return MemberResponseDTO.MemberMissionAcceptResultDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
}
