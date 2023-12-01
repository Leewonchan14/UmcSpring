package umc.spring.umcspring.Converter;

import umc.spring.umcspring.Domain.Enum.MissionStatus;
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Web.Dto.MemberMissionRequestDTO;
import umc.spring.umcspring.Web.Dto.MemberMissionResponseDTO;
import umc.spring.umcspring.Web.Dto.MemberResponseDTO;

public class MemberMissionConvert {
    public static MemberMission toMemberMission(MemberMissionRequestDTO.AcceptDTO request) {
        return MemberMission.builder()
                .build();
    }
    public static MemberMissionResponseDTO.AcceptResultDTO toAcceptResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.AcceptResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
}
