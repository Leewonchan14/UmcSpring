package umc.spring.umcspring.Validation.Annotation;

import umc.spring.umcspring.Validation.Validator.CategoriesExistValidator;
import umc.spring.umcspring.Validation.Validator.MemberExistValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMember {
        String message() default "해당하는 회원이 존재하지 않습니다.";
        Class<?>[] groups() default {};
        Class<?>[] payload() default {};
}
