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
public class Post {  //Post 테이블을 받아올 Post 엔티티

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postID;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "url", length = 100, nullable = false)
    private String url;

    @Column(name = "postDate", nullable = false)
    private LocalDate postDate;

    @Column(name = "startTime", nullable = false)
    private LocalTime startTime;

    @Column(name = "endTime", nullable = false)
    private LocalTime endTime;

    @Column(name = "day", nullable = false)
    private String day;

    @Column(name = "place", nullable = false)
    private String place;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Category> categories;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tag> tags;

    public List<Category> getCategories() {
        return categories;
    }

    public List<Tag> getTags() {
        return tags;
    }

}