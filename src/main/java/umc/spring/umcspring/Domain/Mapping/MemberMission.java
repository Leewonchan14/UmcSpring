package umc.spring.umcspring.Domain.Mapping;

import lombok.*;
import umc.spring.umcspring.Domain.Enum.MissionStatus;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Domain.Mission;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(15) default 'CHALLENGING'")
    private MissionStatus status;

    @ManyToOne
    @JoinColumn(nullable = false, name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(nullable = false, name = "mission_id")
    private Mission mission;
}
