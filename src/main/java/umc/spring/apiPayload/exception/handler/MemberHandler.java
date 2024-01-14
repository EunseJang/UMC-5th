package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralExcpetion;
import umc.spring.domain.Member;

public class MemberHandler extends GeneralExcpetion {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
