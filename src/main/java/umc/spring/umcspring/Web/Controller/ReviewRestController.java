package umc.spring.umcspring.Web.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.umcspring.ApiPayload.ApiResponse;
import umc.spring.umcspring.Converter.ReviewConverter;
import umc.spring.umcspring.Domain.Review;
import umc.spring.umcspring.Service.ReviewService.ReviewCommandService;
import umc.spring.umcspring.Validation.Annotation.ExistMember;
import umc.spring.umcspring.Validation.Annotation.ExistStore;
import umc.spring.umcspring.Web.Dto.ReviewRequestDTO;
import umc.spring.umcspring.Web.Dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    @PostMapping("/stores/{storeId}/members/{memberId}")
    public ApiResponse<ReviewResponseDTO.ReviewCreateResultDTO> createReview(
            @PathVariable @ExistStore Long storeId,
            @PathVariable @ExistMember Long memberId,
            @RequestBody @Valid ReviewRequestDTO.ReviewCreateDTO request
    ){

        Review newReview = reviewCommandService.createReview(storeId, memberId, request);

        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(newReview));
    }
}