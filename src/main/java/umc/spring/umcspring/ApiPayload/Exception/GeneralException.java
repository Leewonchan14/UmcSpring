package umc.spring.umcspring.ApiPayload.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.umcspring.ApiPayload.Code.BaseErrorCode;
import umc.spring.umcspring.ApiPayload.Code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return code.getReasonHttpStatus();
    }
}
