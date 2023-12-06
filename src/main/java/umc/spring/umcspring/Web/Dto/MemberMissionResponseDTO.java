package umc.spring.umcspring.Web.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.umcspring.Domain.Enum.MissionStatus;

import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AcceptResultDTO {
        private Long memberMissionId;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreViewDTO {
        private Long memberId;
        private Long missionId;

        //mission info
        private Integer reward;
        private LocalDateTime deadline;
        private String missionSpec;

        //member mission info
        private MissionStatus missionStatus;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreViewListDTO {
        private List<MemberMissionResponseDTO.MemberMissionPreViewDTO> memberMissionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompleteResultDTO {
        private Long memberMissionId;
        private Integer reward;
        private LocalDateTime updatedAt;
    }
}
