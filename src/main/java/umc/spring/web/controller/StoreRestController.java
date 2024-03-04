package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.service.missionService.MissionCommandService;
import umc.spring.service.reviewService.ReviewCommandService;
import umc.spring.service.storeService.StoreCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.*;

import java.io.IOException;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    private final MissionCommandService missionCommandService;

    /** 특정 가게 등록 */
    @PostMapping("/register")
    public ApiResponse<StoreResponseDTO.registerStoreResultDTO> registerStore(
            @RequestBody @Valid StoreRequestDTO.registerStoreDTO request) {

        Store store = storeCommandService.registerStore(request);
        return ApiResponse.onSucces(StoreConverter.toRegisterStoreResultDTO(store));
    }

    /** 가게 리뷰 등록 */
    @PostMapping(value = "/{storeId}/reviews", consumes = "multipart/form-data")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createReview(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                             @ExistMember @RequestParam(name = "memberId") Long memberId,
                                                                             @RequestBody @Valid ReviewRequestDTO.ReviewDTO request) throws IOException {
        Review review = reviewCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSucces(ReviewConverter.toCreateReviewResultDTO(review));
    }

    /** 가게 미션 등록 */
    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                                @RequestBody @Valid MissionRequestDTO.MissionDTO request) {
        Mission mission = missionCommandService.createMission(storeId, request);
        return ApiResponse.onSucces(MissionConverter.toCreateMissionResultDTO(mission));
    }
}
