package haedal.j4.knuseminar.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Seminar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seminarID;  // 세미나 ID

    @Column(name = "startTime", nullable = false)
    private LocalTime startTime;  // 세미나 시작 시간

    @Column(name = "endTime", nullable = false)
    private LocalTime endTime;  // 세미나 종료 시간

    @Column(length = 5, nullable = false)
    private String day;  // 세미나 요일

    @Column(length = 20, nullable = false)
    private String place;  // 세미나 장소
}