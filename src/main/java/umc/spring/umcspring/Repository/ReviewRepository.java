package umc.spring.umcspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.umcspring.Domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
