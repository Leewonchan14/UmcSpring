package umc.spring.umcspring.Validation.Annotation;

import umc.spring.umcspring.Validation.Validator.StoreExistValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StoreExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStore {
        String message() default "해당하는 가게가 존재하지 않습니다.";
        Class<?>[] groups() default {};
        Class<?>[] payload() default {};
}
