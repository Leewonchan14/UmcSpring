package umc.spring.umcspring.Converter;

import umc.spring.umcspring.Domain.Review;
import umc.spring.umcspring.Web.Dto.ReviewRequestDTO;
import umc.spring.umcspring.Web.Dto.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.CreateReviewDTO request) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResultDTO toCreateResultDTO(Review review) {
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .id(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
