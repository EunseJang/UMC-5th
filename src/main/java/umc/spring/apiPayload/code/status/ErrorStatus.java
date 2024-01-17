package umc.spring.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // common
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 1001, "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, 1002, "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, 1003, "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, 1004, "금지된 요청입니다."),

    // member
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, 2001, "존재하지 않는 사용자입니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, 2002, "닉네임은 필수 입력 사항입니다."),

    // foodCategory
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, 3001, "존재하지 않는 음식 카테고리입니다."),

    // store
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, 4001, "존재하지 않는 가게입니다."),

    // region
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, 5001, "존재하지 않는 지역입니다."),

    // mission
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, 6001, "존재하지 않는 미션입니다."),
    MEMBER_MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, 6002, "사용자의 미션이 존재하지 않습니다."),
    MISSION_ALREADY_CHALLENGING(HttpStatus.CONFLICT, 6002, "이미 도전중인 미션입니다."),

    // test
    TEMP_EXCEPTION_TEST(HttpStatus.BAD_REQUEST, 9001, "테스트용");


    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
