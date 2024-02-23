package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.reviewService.ReviewQueryService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.ReviewResponseDTO;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API (페이징 포함). Query String 으로 Page 번호 사용")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON-200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH-003", description = "accessToken 요청", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH-004", description = "accessToken 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH-005", description = "accessToken 형식 오류",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게 id를 Path Variable로 사용"),
            @Parameter(name = "page", description = "페이지 번호 (0부터 시작)")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        reviewQueryService.getReviewList(storeId, page);

        // TODO Page 번호를 음수로 입력했을때의 Custom Annotation 설정

        return null;
    }
}
