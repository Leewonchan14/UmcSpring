package umc.spring.umcspring.Web.Dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MissionRequestDTO {
    @Getter
    public static class CreateMissionDTO {
        @NotNull
        Integer reward;
        @NotNull
        LocalDateTime deadline;
        @NotNull
        String missionSpec;
    }
}
