package umc.spring.umcspring.Web.Dto;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewCreateDTO {
        @NotBlank
        private String title;

        @NotBlank
        private String body;
        @Max(5)
        @Min(0)
        private Float score;
    }
}
