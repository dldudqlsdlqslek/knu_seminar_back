package haedal.j4.knuseminar.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    @Id
    @Column(name="tagID", nullable=false)
    private Integer tagID;  // 포스트 ID

    @Column(name = "tagText", length = 20, nullable = false)
    private String tagText;  // 태그 내용

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postID")  // Post의 외래 키
    private Post post;  // 여러 태그가 하나의 게시글에 속함
}
