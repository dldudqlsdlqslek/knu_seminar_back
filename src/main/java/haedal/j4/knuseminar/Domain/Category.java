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
    @Column(name = "categoryID", nullable = false)
    private Integer categoryID;  // 포스트 ID

    @Column(name = "categoryText", length = 20, nullable = false)
    private String categoryText;  // 카테고리 내용

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postID")  // Post의 외래 키
    private Post post;  // 여러 카테고리가 하나의 게시글에 속함
}