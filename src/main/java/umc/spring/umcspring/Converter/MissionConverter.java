package umc.spring.umcspring.Converter;

import umc.spring.umcspring.Domain.Mission;
import umc.spring.umcspring.Web.Dto.MissionRequestDTO;
import umc.spring.umcspring.Web.Dto.MissionResponseDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.MissionCreateDTO request) {
        return Mission.builder()
                .reward(request.getReward())
                .missionSpec(request.getMissionSpec())
                .deadline(request.getDeadline()).build();
    }
    public static MissionResponseDTO.MissionCreateResultDTO toCreateMissionResultDTO(Mission mission) {
        return MissionResponseDTO.MissionCreateResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
