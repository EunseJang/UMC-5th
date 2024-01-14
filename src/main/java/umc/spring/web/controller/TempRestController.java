package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.TempConverter;
import umc.spring.service.tempService.TempQueryService;
import umc.spring.web.dto.TempResponseDTO;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponseDTO.TempTestDTO> testAPI() {
        return ApiResponse.onSucces(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponseDTO.TempExceptionDTO> exceptionAPI (@RequestParam("flag") Integer flag) {
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSucces(TempConverter.toTempExceptionDTO(flag));
    }
}
