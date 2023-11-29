package umc.spring.umcspring.Web.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReviewResponseDTO {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class CreateReviewResultDTO {
        private Long id;
        private LocalDateTime createdAt;
    }
}
