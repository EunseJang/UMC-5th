package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDTO {
        @NotBlank
        String content;
        @NotNull
        Float score;
        // TODO 리뷰 이미지 처리 방법?
        //List<String> reviewImageUrl;
    }
}
