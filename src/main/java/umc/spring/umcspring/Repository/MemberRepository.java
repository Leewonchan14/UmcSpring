package umc.spring.umcspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.umcspring.Domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
