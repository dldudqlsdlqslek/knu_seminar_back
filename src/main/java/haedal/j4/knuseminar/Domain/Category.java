package haedal.j4.knuseminar.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {  //Category 테이블을 받아올 Category 엔티티


    //categoryID 칼럼 - PK, (카테고리, 소속된 게시글) 정보를 구분
    @Id
    @Column(name = "categoryID", nullable = false)
    private Integer categoryID;

    //categoryText 칼럼 - 카테고리 종류 텍스트
    @Column(name = "categoryText", length = 20, nullable = false)
    private String categoryText;


    //postID 칼럼 - Post를 참조하는 FK, 소속된 게시글의 ID
    @ManyToOne(fetch = FetchType.EAGER) //하나의 게시글의 여러개의 카테고리가 소속 - ManyToOne 매핑
    @JoinColumn(name = "postID")
    private Post post;
}