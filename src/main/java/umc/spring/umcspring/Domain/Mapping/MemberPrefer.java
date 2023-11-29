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

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getMemberPreferList().remove(this);
        }
        this.member = member;
        if (!member.getMemberPreferList().contains(this)) {
            member.getMemberPreferList().add(this);
        }
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }
}
