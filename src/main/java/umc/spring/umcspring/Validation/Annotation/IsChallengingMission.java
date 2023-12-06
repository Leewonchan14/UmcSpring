package umc.spring.umcspring.Validation.Annotation;

import umc.spring.umcspring.Validation.Validator.MemberMissionIsChallengingValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionIsChallengingValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsChallengingMission {
    String message() default "이미 완료한 미션입니다.";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
