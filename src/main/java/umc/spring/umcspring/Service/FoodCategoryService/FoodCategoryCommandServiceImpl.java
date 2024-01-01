package umc.spring.umcspring.Service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.umcspring.Repository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryCommandServiceImpl implements FoodCategoryCommandService {

    private final FoodCategoryRepository foodCategoryRepository;
    @Override
    public Boolean isExist(List<Long> values) {
        return values.stream()
                .allMatch(foodCategoryRepository::existsById);
    }
}
