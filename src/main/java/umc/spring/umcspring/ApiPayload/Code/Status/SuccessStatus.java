package umc.spring.umcspring.ApiPayload.Code.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.umcspring.ApiPayload.Code.BaseCode;
import umc.spring.umcspring.ApiPayload.Code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK, "2000", "Ok"),;

    private HttpStatus httpStatus;
    private String code;
    private String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .code(message)
                .message(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .code(message)
                .message(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
