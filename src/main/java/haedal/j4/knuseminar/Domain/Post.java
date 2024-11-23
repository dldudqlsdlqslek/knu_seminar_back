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
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate postDate;  // 게시글 작성일

    @Column(name = "startTime", nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalTimeConverter.class)
    private LocalTime startTime;

    @Column(name = "endTime", nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalTimeConverter.class)
    private LocalTime endTime;

    @Column(name = "day", nullable = false)
    private String day;

    @Column(name = "place", nullable = false)
    private String place;

    @ManyToMany
    @JoinTable(
            name = "category",  // 중간 테이블 이름
            joinColumns = @JoinColumn(name = "postID"),  // Post의 외래 키
            inverseJoinColumns = @JoinColumn(name = "categoryText")  // Category의 외래 키
    )
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    @ManyToMany
    @JoinTable(
            name = "tag",  // 중간 테이블 이름
            joinColumns = @JoinColumn(name = "postID"),  // Post의 외래 키
            inverseJoinColumns = @JoinColumn(name = "tagText")  // Tag의 외래 키
    )
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

}