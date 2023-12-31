package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralExcpetion;

public class TempHandler extends GeneralExcpetion {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
