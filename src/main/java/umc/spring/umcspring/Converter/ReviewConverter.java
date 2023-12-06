package umc.spring.umcspring.Converter;

import org.springframework.data.domain.Page;
import umc.spring.umcspring.Domain.Review;
import umc.spring.umcspring.Web.Dto.ReviewRequestDTO;
import umc.spring.umcspring.Web.Dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.ReviewCreateDTO request) {
        return Review.builder()
                .title(request.getTitle())
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

    public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .title(review.getTitle())
                .body(review.getBody())
                .score(review.getScore())
                .createdAt(review.getCreatedAt())
                .build();
    }
    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream().map(ReviewConverter::reviewPreViewDTO)
                .collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
