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
    @Column(name="postID", nullable=false)
    private Integer postID;  // 포스트 ID

    @Column(name = "tagText", length = 20, nullable = false)
    private String tagText;  // 태그 내용
}
