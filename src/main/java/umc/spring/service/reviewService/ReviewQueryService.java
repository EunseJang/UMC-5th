package umc.spring.service.reviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface ReviewQueryService {

    Page<Review> getReviewList(Long storeId, Integer page);
}
