package umc.spring.umcspring.Domain.Mapping;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.umcspring.Domain.Common.BaseEntity;
import umc.spring.umcspring.Domain.Enum.MissionStatus;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Domain.Mission;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
public class MemberMission extends BaseEntity {
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


    public void setMission(Mission mission) {
        if (this.mission != null) {
            this.mission.getMemberMissionList().remove(this);
        }
        this.mission = mission;
        if (!mission.getMemberMissionList().contains(this)) {
            mission.getMemberMissionList().add(this);
        }
    }

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getMemberMissionList().remove(this);
        }
        this.member = member;
        if (!member.getMemberMissionList().contains(this)) {
            member.getMemberMissionList().add(this);
        }
    }
}
