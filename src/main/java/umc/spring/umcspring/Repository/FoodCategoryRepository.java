package umc.spring.umcspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.umcspring.Domain.FoodCategory;

public interface FoodCategoryRepository  extends JpaRepository<FoodCategory, Long> {

}
