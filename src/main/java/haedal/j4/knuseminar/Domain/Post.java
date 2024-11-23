package haedal.j4.knuseminar.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postID;  // 게시글 ID

    @Column(name = "title", length = 100, nullable = false)
    private String title;  // 게시글 제목

    @Column(name = "url", length = 100, nullable = false)
    private String url;  // 원본 게시글 링크

    @Column(name = "postDate", nullable = false)
    private LocalDate postDate;  // 게시글 작성일

    @Column(name = "startTime", nullable = false)
    private LocalTime startTime;

    @Column(name = "endTime", nullable = false)
    private LocalTime endTime;

    @Column(name = "day", nullable = false)
    private String day;

    @Column(name = "place", nullable = false)
    private String place;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Category> categories;  // 하나의 게시글에 여러 카테고리

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tag> tags;  // 하나의 게시글에 여러 태그

    public List<Category> getCategories() {
        return categories;
    }

    public List<Tag> getTags() {
        return tags;
    }

}