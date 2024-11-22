package haedal.j4.knuseminar.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postID;  // 게시글 ID

    @OneToOne
    @JoinColumn(name = "seminar_id", nullable = false)
    private Seminar seminar;  // 세미나와 1:1 관계 (세미나 ID)

    @Column(length = 50, nullable = false)
    private String title;  // 게시글 제목

    @Column(length = 100, nullable = false)
    private String url;  // 원본 게시글 링크

    @Column(name = "postDate", nullable = false)
    private LocalDate postDate;  // 게시글 작성일

    @ManyToMany
    @JoinTable(
            name = "Post_Tag",  // 중간 테이블 이름
            joinColumns = @JoinColumn(name = "postID"),  // Post의 외래 키
            inverseJoinColumns = @JoinColumn(name = "tagID")  // Tag의 외래 키
    )
    private Set<Tag> tags = new HashSet<>();  // 태그와 다대다 관계

    @ManyToMany
    @JoinTable(
            name = "Post_Category",  // 중간 테이블 이름
            joinColumns = @JoinColumn(name = "postID"),  // Post의 외래 키
            inverseJoinColumns = @JoinColumn(name = "categoryID")  // Category의 외래 키
    )
    private Set<Category> categories = new HashSet<>();  // 카테고리와 다대다 관계

    public Post(Seminar seminar, String title, String url, LocalDate postDate) {
        this.seminar = seminar;
        this.title = title;
        this.url = url;
        this.postDate = postDate;
    }
}