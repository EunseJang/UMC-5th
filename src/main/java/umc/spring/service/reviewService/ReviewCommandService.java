package umc.spring.service.reviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

import java.io.IOException;

public interface ReviewCommandService {

    Review createReview(Long memberId, Long storeId, ReviewRequestDTO.ReviewDTO request) throws IOException;
}
