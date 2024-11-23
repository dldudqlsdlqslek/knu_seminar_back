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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryID;  // 카테고리 ID

    @Column(length = 20, nullable = false)
    private String categoryText;  // 카테고리 내용
}