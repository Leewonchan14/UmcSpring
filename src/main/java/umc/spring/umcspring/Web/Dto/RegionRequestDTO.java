package umc.spring.umcspring.Web.Dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class RegionRequestDTO {
    @Getter
    public static class CreateDTO{
        @NotBlank
        String name;
    }
}
