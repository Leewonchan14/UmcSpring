package umc.spring.umcspring.Converter;

import umc.spring.umcspring.Domain.FoodCategory;
import umc.spring.umcspring.Domain.Mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory -> MemberPrefer.builder()
                        .foodCategory(foodCategory)
                        .build())
                .collect(Collectors.toList());
    }
}
