package umc.spring.umcspring.Domain;

import lombok.*;
import umc.spring.umcspring.Domain.Common.BaseEntity;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(nullable = false, name = "review_id")
    private Review review;
}
