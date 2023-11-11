package umc.spring.umcspring.Domain.Mapping;

import lombok.*;
import umc.spring.umcspring.Domain.FoodCategory;
import umc.spring.umcspring.Domain.Member;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberPrefer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;
}
