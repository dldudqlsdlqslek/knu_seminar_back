package haedal.j4.knuseminar.ResponseDTO;


import haedal.j4.knuseminar.Domain.Category;
import haedal.j4.knuseminar.Domain.Tag;
import lombok.Getter;

import java.time.LocalTime;
import java.util.List;

@Getter
public class PostDetailResponseDTO {
    private Integer postID;
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;
    private String day;
    private String place;
    private String url;
    private List<Tag> tags;
    private List<Category> categories;

}
