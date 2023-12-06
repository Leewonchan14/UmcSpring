package umc.spring.umcspring.Converter;

import org.springframework.data.domain.Page;
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Web.Dto.MemberMissionRequestDTO;
import umc.spring.umcspring.Web.Dto.MemberMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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
    public static MemberMissionResponseDTO.MemberMissionPreViewDTO toMemberMissionPreViewDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionPreViewDTO.builder()
                .memberMissionId(memberMission.getId())
                .reward(memberMission.getMission().getReward())
                .deadline(memberMission.getMission().getDeadline())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .missionStatus(memberMission.getStatus())
                .createdAt(memberMission.getCreatedAt())
                .updatedAt(memberMission.getUpdatedAt())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreViewListDTO toMemberMissionPreViewListDTO(Page<MemberMission> memberMissionList) {
        List<MemberMissionResponseDTO.MemberMissionPreViewDTO> memberMissionPreViewDTOS = memberMissionList.stream().map(MemberMissionConvert::toMemberMissionPreViewDTO)
                .collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionPreViewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(memberMissionPreViewDTOS.size())
                .memberMissionList(memberMissionPreViewDTOS)
                .build();
    }
}
