package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    // TODO 메서드 명 변경
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class registerStoreResultDTO {
        Long storeId;
        LocalDateTime createdAt;
    }
}
