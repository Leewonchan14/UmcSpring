package umc.spring.umcspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.umcspring.Domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
