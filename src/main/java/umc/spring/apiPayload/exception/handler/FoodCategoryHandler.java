package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralExcpetion;

public class FoodCategoryHandler extends GeneralExcpetion {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
