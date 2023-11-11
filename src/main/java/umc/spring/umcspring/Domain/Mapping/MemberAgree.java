package umc.spring.umcspring.Domain.Mapping;

import lombok.*;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Domain.Terms;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberAgree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    public Member member;

    @ManyToOne
    @JoinColumn(name = "terms_id")
    public Terms terms;
}
