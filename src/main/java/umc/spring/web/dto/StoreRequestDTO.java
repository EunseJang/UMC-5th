package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRegion;

public class StoreRequestDTO {

    // TODO 메서드 명 변경
    @Getter
    public static class registerStoreDTO {

        @NotNull
        String name;
        @NotNull
        String address;

        // TODO Body로 지역 값 보내기 vs Param으로 보내기
        @ExistRegion
        String region;
    }
}
