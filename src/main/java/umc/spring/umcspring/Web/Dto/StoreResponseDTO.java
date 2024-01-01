package umc.spring.umcspring.Web.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class StoreResponseDTO {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StoreCreateResultDTO {
        private Long storeId;
        private LocalDateTime createdAt;
    }
}
