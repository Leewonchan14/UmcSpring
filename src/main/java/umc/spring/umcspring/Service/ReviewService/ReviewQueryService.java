package umc.spring.umcspring.Service.ReviewService;

import org.springframework.data.domain.Page;
import umc.spring.umcspring.Domain.Review;

public interface ReviewQueryService {
    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Review> getMyReviewList(Long storeId, Long memberId, Integer page);
}
