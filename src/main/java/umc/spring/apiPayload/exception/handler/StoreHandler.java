package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralExcpetion;

public class StoreHandler extends GeneralExcpetion {

    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
