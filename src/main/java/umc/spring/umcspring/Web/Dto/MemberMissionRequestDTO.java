package umc.spring.umcspring.Web.Dto;

import lombok.Getter;
import umc.spring.umcspring.Validation.Annotation.ExistMember;
import umc.spring.umcspring.Validation.Annotation.ExistMission;

public class MemberMissionRequestDTO {
    @Getter
    public static class AcceptDTO {
        @ExistMember
        Long memberId;
        @ExistMission
        Long missionId;
    }

    @Getter
    public static class CompleteDTO extends AcceptDTO{
    }
}
