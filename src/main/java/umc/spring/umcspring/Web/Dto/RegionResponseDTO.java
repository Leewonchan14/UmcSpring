package umc.spring.umcspring.Web.Dto;

import lombok.*;

import java.time.LocalDateTime;

public class RegionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRegionResultDTO {
        private Long regionId;
        private LocalDateTime createdAt;
    }
}
