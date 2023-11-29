package umc.spring.umcspring.Web.Dto;

import lombok.Getter;
import umc.spring.umcspring.Validation.Annotation.ExistRegion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StoreRequestDTO {
    @Getter
    public static class CreateDTO{
        @NotBlank
        private String name;
        @Size(min = 5, max = 12)
        private String address;
        @ExistRegion
        private Long regionId;
    }
}
