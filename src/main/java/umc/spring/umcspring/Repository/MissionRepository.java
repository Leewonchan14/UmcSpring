package umc.spring.umcspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.umcspring.Domain.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

}
