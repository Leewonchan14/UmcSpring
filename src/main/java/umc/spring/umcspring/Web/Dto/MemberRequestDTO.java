package umc.spring.umcspring.Web.Dto;

import lombok.Getter;
import umc.spring.umcspring.Validation.Annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDTO {
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer age;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}
