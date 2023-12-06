package umc.spring.umcspring.Service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.umcspring.Domain.Review;
import umc.spring.umcspring.Domain.Store;
import umc.spring.umcspring.Repository.ReviewRepository;
import umc.spring.umcspring.Repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        return reviewRepository.findByStore(store, PageRequest.of(page, 10));
    }
}
