package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.Store;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class MissionDTO {
        @NotNull
        private Integer reword;
        @NotNull
        private LocalDate deadline;
        @NotBlank
        private String specMission;
    }
}
