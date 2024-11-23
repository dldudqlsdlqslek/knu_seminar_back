package haedal.j4.knuseminar.ResponseDTO;


import haedal.j4.knuseminar.Domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PostSimpleResponseDTO {
    private Integer postID;
    private String title;
    private String url;
    private List<String> category;
    private LocalDate postDate;

    public PostSimpleResponseDTO(Integer postID, String title, String url, List<String> category, LocalDate postDate) {
        this.postID = postID;
        this.title = title;
        this.url = url;
        this.category = category;
        this.postDate = postDate;
    }
}
