package umc.spring.umcspring.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Domain.Review;
import umc.spring.umcspring.Domain.Store;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByStore(Store store, PageRequest pageRequest);

    Page<Review> findByStoreAndMember(Store store, Member member, PageRequest pageRequest);
}
