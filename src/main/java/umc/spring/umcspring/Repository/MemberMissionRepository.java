package umc.spring.umcspring.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Domain.Member;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    // exists by member id and mission id
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);

    Page<MemberMission> findByMember(Member member, Pageable pageable);

}
