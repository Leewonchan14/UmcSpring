package umc.spring.umcspring.Domain;

import lombok.*;
import umc.spring.umcspring.Domain.Common.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    private Float score;

    @ManyToOne
    @JoinColumn(nullable = false, name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(nullable = false, name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    @Builder.Default
    private List<ReviewImage> reviewImageList = new ArrayList<>();

    public void setMember(Member member) {
        this.member = member;

        List<Review> reviewList = member.getReviewList();

        if (!reviewList.contains(this))
            reviewList.add(this);
    }

    public void setStore(Store store) {
        this.store = store;

        List<Review> reviewList = store.getReviewList();

        if (!reviewList.contains(this))
            reviewList.add(this);
    }
}
