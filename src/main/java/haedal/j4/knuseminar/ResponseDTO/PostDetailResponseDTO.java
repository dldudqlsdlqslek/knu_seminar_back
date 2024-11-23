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
    private List<String> tags;
    private List<String> categories;


    public PostDetailResponseDTO(Integer postID, String title, LocalTime startTime, LocalTime endTime,
                                 String day, String place, String url,
                                 List<String> tags, List<String> categories)
    {
        this.postID = postID;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
        this.place = place;
        this.url = url;
        this.tags = tags;
        this.categories = categories;
    }
}
