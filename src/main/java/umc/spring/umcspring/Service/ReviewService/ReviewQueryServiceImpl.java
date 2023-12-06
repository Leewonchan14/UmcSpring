package umc.spring.umcspring.Service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Domain.Review;
import umc.spring.umcspring.Domain.Store;
import umc.spring.umcspring.Repository.MemberRepository;
import umc.spring.umcspring.Repository.ReviewRepository;
import umc.spring.umcspring.Repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        return reviewRepository.findByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<Review> getMyReviewList(Long storeId, Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        Store store = storeRepository.findById(storeId).get();

        return reviewRepository.findByStoreAndMember(store, member, PageRequest.of(page, 10));
    }
}
