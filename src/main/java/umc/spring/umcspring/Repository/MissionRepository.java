package umc.spring.umcspring.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.umcspring.Domain.Mission;
import umc.spring.umcspring.Domain.Store;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findByStore(Store store, Pageable pageable);
}
