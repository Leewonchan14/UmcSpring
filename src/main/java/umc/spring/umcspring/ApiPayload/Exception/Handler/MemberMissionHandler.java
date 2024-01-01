package umc.spring.umcspring.ApiPayload.Exception.Handler;

import umc.spring.umcspring.ApiPayload.Code.BaseErrorCode;
import umc.spring.umcspring.ApiPayload.Exception.GeneralException;

public class MemberMissionHandler extends GeneralException {
    public MemberMissionHandler(BaseErrorCode code) {
        super(code);
    }
}
