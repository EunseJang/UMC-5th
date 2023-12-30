package umc.spring.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseCode;
import umc.spring.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    // common
    _OK(HttpStatus.OK, 1001, "success");

    // memeber

    // foodCategory

    // store

    // test

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
