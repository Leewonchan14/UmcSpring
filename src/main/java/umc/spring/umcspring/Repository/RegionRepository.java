package umc.spring.umcspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.umcspring.Domain.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
