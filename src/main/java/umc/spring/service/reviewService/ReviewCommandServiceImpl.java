package umc.spring.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.Repository.MemberRepository;
import umc.spring.Repository.ReviewRepository;
import umc.spring.Repository.StoreRepository;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Review createReview(Long memberId, Long storeId, ReviewRequestDTO.ReviewDTO request) {
        Review review = ReviewConverter.toReview(request);

//        review.setMember(memberRepository.findById(memberId)
//                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)));
//        review.setStore(storeRepository.findById(storeId)
//                .orElseThrow(() -> new StoreHandler(ErrorStatus.REGION_NOT_FOUND)));

        review.setMember(memberRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }
}
