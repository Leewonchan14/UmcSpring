package umc.spring.umcspring.Validation.Validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.umcspring.ApiPayload.Code.Status.ErrorStatus;
import umc.spring.umcspring.Service.MemberMissionService.MemberMissionQueryService;
import umc.spring.umcspring.Validation.Annotation.IsChallengingMission;
import umc.spring.umcspring.Web.Dto.MemberMissionRequestDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MemberMissionIsChallengingValidator implements ConstraintValidator<IsChallengingMission, MemberMissionRequestDTO.CompleteDTO> {

    private final MemberMissionQueryService memberMissionQueryService;
    @Override
    public void initialize(IsChallengingMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.CompleteDTO value, ConstraintValidatorContext context) {

        boolean isValid = memberMissionQueryService.isChallenging(value.getMemberId(), value.getMissionId());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_COMPLETE.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
