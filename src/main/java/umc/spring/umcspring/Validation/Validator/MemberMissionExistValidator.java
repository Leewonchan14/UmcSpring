package umc.spring.umcspring.Validation.Validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.umcspring.ApiPayload.Code.Status.ErrorStatus;
import umc.spring.umcspring.Service.MemberMissionService.MemberMissionQueryService;
import umc.spring.umcspring.Validation.Annotation.ExistMemberMission;
import umc.spring.umcspring.Web.Dto.MemberMissionRequestDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MemberMissionExistValidator implements ConstraintValidator<ExistMemberMission, MemberMissionRequestDTO.AcceptDTO> {

    private final MemberMissionQueryService memberMissionQueryService;

    @Override
    public void initialize(ExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.AcceptDTO value, ConstraintValidatorContext context) {

        boolean isExist = memberMissionQueryService.isExist(value.getMemberId(), value.getMissionId());

        boolean isValid = !isExist;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_EXIST.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
