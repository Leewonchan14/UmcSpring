package umc.spring.umcspring.Service.ReviewService;

import umc.spring.umcspring.Domain.Review;
import umc.spring.umcspring.Web.Dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review createReview(Long storeId, Long memberId, ReviewRequestDTO.ReviewCreateDTO request);
}
