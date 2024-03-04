package umc.spring.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.Repository.MemberRepository;
import umc.spring.Repository.ReviewImageRepository;
import umc.spring.Repository.ReviewRepository;
import umc.spring.Repository.StoreRepository;
import umc.spring.Repository.UuidRepository;
import umc.spring.Util.Uuid;
import umc.spring.aws.AmazonS3Manager;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final AmazonS3Manager s3Manager;
    private final UuidRepository uuidRepository;
    private final ReviewImageRepository reviewImageRepository;

    @Override
    @Transactional
    public Review createReview(Long memberId, Long storeId, ReviewRequestDTO.ReviewDTO request) throws IOException {
        Review review = ReviewConverter.toReview(request);

        String uuid = UUID.randomUUID().toString();
        Uuid savedUuid = uuidRepository.save(Uuid.builder().uuid(uuid).build());
        String imageUrl = s3Manager.uploadFile(s3Manager.generateReviewKeyName(savedUuid), request.getReviewPicture());

        review.setMember(memberRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());

        reviewImageRepository.save(ReviewConverter.toReviewImage(imageUrl, review));
        return reviewRepository.save(review);
    }
}
