package umc.spring.umcspring.Web.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.umcspring.ApiPayload.ApiResponse;
import umc.spring.umcspring.Converter.ReviewConverter;
import umc.spring.umcspring.Domain.Review;
import umc.spring.umcspring.Service.ReviewService.ReviewCommandService;
import umc.spring.umcspring.Service.ReviewService.ReviewQueryService;
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
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/stores/{storeId}/members/{memberId}")
    public ApiResponse<ReviewResponseDTO.ReviewCreateResultDTO> createReview(
            @PathVariable @ExistStore Long storeId,
            @PathVariable @ExistMember Long memberId,
            @RequestBody @Valid ReviewRequestDTO.ReviewCreateDTO request
    ) {

        Review newReview = reviewCommandService.createReview(storeId, memberId, request);

        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(newReview));
    }

    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })

    @GetMapping("/stores/{storeId}")
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(
            @PathVariable @ExistStore Long storeId,
            @RequestParam(name = "page") Integer page
    ) {
        return ApiResponse.onSuccess(
                ReviewConverter.reviewPreViewListDTO(
                        reviewQueryService.getReviewList(storeId, page)
                )
        );
    }
}
