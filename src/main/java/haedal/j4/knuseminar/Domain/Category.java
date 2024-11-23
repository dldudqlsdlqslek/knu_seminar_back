package haedal.j4.knuseminar.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "postID", nullable = false)
    private Integer postID;  // 포스트 ID


    @Column(name = "categoryText", length = 20, nullable = false)
    private String categoryText;  // 카테고리 내용
}