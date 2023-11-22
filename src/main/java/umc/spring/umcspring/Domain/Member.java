package umc.spring.umcspring.Domain;

import lombok.*;
import umc.spring.umcspring.Domain.Common.BaseEntity;
import umc.spring.umcspring.Domain.Enum.Gender;
import umc.spring.umcspring.Domain.Enum.SocialType;
import umc.spring.umcspring.Domain.Enum.MemberStatus;
import umc.spring.umcspring.Domain.Mapping.MemberAgree;
import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Domain.Mapping.MemberPrefer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    private Integer age;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(15) default 'ACTIVE'")
    private MemberStatus memberStatus;

    private LocalDateTime inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;

    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

}
