package umc.spring.umcspring.Validation.Annotation;

import umc.spring.umcspring.Validation.Validator.MemberMissionNotExistValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionNotExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotExistMemberMission {
    String message() default "미션을 먼저 수락해야 합니다.";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
