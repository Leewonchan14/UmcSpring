package umc.spring.umcspring.Converter;

import umc.spring.umcspring.Domain.Mission;
import umc.spring.umcspring.Web.Dto.MissionRequestDTO;
import umc.spring.umcspring.Web.Dto.MissionResponseDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.CreateMissionDTO request) {
        return Mission.builder()
                .reward(request.getReward())
                .missionSpec(request.getMissionSpec())
                .deadline(request.getDeadline()).build();
    }
    public static MissionResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission) {
        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
