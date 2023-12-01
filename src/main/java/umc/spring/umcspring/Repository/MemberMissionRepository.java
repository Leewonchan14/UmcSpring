package umc.spring.umcspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.umcspring.Domain.Mapping.MemberMission;

import java.util.Optional;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Optional<MemberMission> findAllByMemberIdAndMissionId(Long memberId, Long missionId);

    // exists by member id and mission id
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);

    // findBy member id and mission id
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}
