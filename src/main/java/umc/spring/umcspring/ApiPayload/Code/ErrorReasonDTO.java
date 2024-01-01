package umc.spring.umcspring.ApiPayload.Code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ErrorReasonDTO {
    private String code;
    private String message;
    private HttpStatus httpStatus;
    private Boolean isSuccess;
}
