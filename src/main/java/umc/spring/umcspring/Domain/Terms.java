package umc.spring.umcspring.Domain;

import lombok.*;
import umc.spring.umcspring.Domain.Common.BaseEntity;
import umc.spring.umcspring.Domain.Mapping.MemberAgree;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Terms extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean optional;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}
