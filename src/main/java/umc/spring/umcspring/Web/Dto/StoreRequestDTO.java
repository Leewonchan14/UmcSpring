package umc.spring.umcspring.Web.Dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StoreRequestDTO {
    @Getter
    public static class CreateStoreDTO {
        @NotBlank
        private String name;
        @Size(min = 5, max = 12)
        private String address;
    }
}
