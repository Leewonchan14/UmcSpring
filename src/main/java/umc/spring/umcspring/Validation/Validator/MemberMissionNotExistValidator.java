package umc.spring.umcspring.Validation.Validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.umcspring.ApiPayload.Code.Status.ErrorStatus;
import umc.spring.umcspring.Service.MemberMissionService.MemberMissionQueryService;
import umc.spring.umcspring.Validation.Annotation.NotExistMemberMission;
import umc.spring.umcspring.Web.Dto.MemberMissionRequestDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MemberMissionNotExistValidator implements ConstraintValidator<NotExistMemberMission, MemberMissionRequestDTO.CompleteDTO> {
    private final MemberMissionQueryService memberMissionQueryService;
    @Override
    public void initialize(NotExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.CompleteDTO value, ConstraintValidatorContext context) {

        boolean isValid = memberMissionQueryService.isExist(value.getMemberId(), value.getMissionId());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_EXIST.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
