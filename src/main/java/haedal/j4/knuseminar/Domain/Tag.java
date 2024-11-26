package haedal.j4.knuseminar.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {   //Tag 테이블을 받아올 Tag 엔티티



    @Id
    @Column(name="tagID", nullable=false)
    private Integer tagID;

    @Column(name = "tagText", length = 20, nullable = false)
    private String tagText;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postID")
    private Post post;
}
