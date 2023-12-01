package umc.spring.umcspring.Converter;

import umc.spring.umcspring.Domain.Review;
import umc.spring.umcspring.Web.Dto.ReviewRequestDTO;
import umc.spring.umcspring.Web.Dto.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.ReviewCreateDTO request) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }

    public static ReviewResponseDTO.ReviewCreateResultDTO toCreateReviewResultDTO(Review review) {
        return ReviewResponseDTO.ReviewCreateResultDTO.builder()
                .id(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
