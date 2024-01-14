package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.service.reviewService.ReviewCommandService;
import umc.spring.service.storeService.StoreCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;

    /** 특정 가게 등록 */
    @PostMapping("/register")
    public ApiResponse<StoreResponseDTO.registerStoreResultDTO> registerStore(
            @RequestBody @Valid StoreRequestDTO.registerStoreDTO request) {

        Store store = storeCommandService.registerStore(request);
        return ApiResponse.onSucces(StoreConverter.toRegisterStoreResultDTO(store));
    }

    /** 가게 리뷰 등록 */
    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createReview(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                             @ExistMember @RequestParam(name = "memberId") Long memberId,
                                                                             @RequestBody @Valid ReviewRequestDTO.ReviewDTO request) {
        Review review = reviewCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSucces(ReviewConverter.toCreateReviewResultDTO(review));
    }
}
