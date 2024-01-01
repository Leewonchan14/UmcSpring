package umc.spring.umcspring.Validation.Annotation;

import umc.spring.umcspring.Validation.Validator.MissionExistValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMission {
        String message() default "해당하는 미션을 찾을 수 없습니다.";
        Class<?>[] groups() default {};
        Class<?>[] payload() default {};
}
