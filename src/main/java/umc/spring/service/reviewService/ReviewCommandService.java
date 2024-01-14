package umc.spring.service.reviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review createReview(Long memberId, Long storeId, ReviewRequestDTO.ReviewDTO request);
}
