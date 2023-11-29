package umc.spring.umcspring.ApiPayload.Exception.Handler;

import umc.spring.umcspring.ApiPayload.Code.BaseErrorCode;
import umc.spring.umcspring.ApiPayload.Exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
