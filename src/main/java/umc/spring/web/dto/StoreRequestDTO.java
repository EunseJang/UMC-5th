package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRegions;

public class StoreRequestDTO {

    @Getter
    public static class registerStoreDTO {

        @NotNull
        String name;
        @NotNull
        String address;
        @ExistRegions
        String region;
    }
}
