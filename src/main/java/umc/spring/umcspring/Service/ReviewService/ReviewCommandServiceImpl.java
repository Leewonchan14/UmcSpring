package umc.spring.umcspring.Service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.umcspring.Converter.ReviewConverter;
import umc.spring.umcspring.Domain.Review;
import umc.spring.umcspring.Repository.MemberRepository;
import umc.spring.umcspring.Repository.ReviewRepository;
import umc.spring.umcspring.Repository.StoreRepository;
import umc.spring.umcspring.Web.Dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;

    private final StoreRepository storeRepository;

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review createReview(Long storeId, Long memberId, ReviewRequestDTO.ReviewCreateDTO request) {
        Review newReview = ReviewConverter.toReview(request);

        newReview.setStore(storeRepository.findById(storeId).get());

        newReview.setMember(memberRepository.findById(memberId).get());

        return reviewRepository.save(newReview);
    }
}
