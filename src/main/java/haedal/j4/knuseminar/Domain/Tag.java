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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagID;  // 태그 ID

    @Column(length = 20, nullable = false)
    private String tagText;  // 태그 내용
}
