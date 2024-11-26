package haedal.j4.knuseminar.RequestDTO;


import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class PostCreateRequestDTO {      //Post 생성 시 입력 정보 DTO
    private String title;
    private String url;
    private List<String> categories;
    private LocalDate postDate;

    public PostCreateRequestDTO(String title, String url, List<String> categories, LocalDate postDate) {
        this.title = title;
        this.url = url;
        this.categories = categories;
        this.postDate = postDate;
    }
}
