package haedal.j4.knuseminar.Service;


import haedal.j4.knuseminar.Domain.Category;
import haedal.j4.knuseminar.Domain.Post;
import haedal.j4.knuseminar.Domain.Tag;
import haedal.j4.knuseminar.Repository.PostRepository;
import haedal.j4.knuseminar.ResponseDTO.PostDetailResponseDTO;
import haedal.j4.knuseminar.ResponseDTO.PostSimpleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostSimpleResponseDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> new PostSimpleResponseDTO(
                        post.getPostID(),
                        post.getTitle(),
                        post.getUrl(),
                        post.getCategories().stream()
                                .map(Category::getCategoryText)  // Category의 이름을 리스트로 변환
                                .collect(Collectors.toList()),
                        post.getPostDate()))
                .collect(Collectors.toList());
    }

    public PostDetailResponseDTO getPostsDetails(Integer postID) {
        Post post = postRepository.findById(postID)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with ID: " + postID));

        return new PostDetailResponseDTO(
                post.getPostID(),
                post.getTitle(),
                post.getStartTime(),
                post.getEndTime(),
                post.getDay(),
                post.getPlace(),
                post.getUrl(),
                post.getTags().stream()
                        .map(Tag::getTagText)
                        .collect(Collectors.toList()),
                post.getCategories().stream()
                        .map(Category::getCategoryText)
                        .collect(Collectors.toList())

        );
    }

    public List<PostSimpleResponseDTO> postSearch(String query, List<String> timeRanges,
                                                   String place, String tag, String category) {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .filter(post -> query == null || post.getTitle().contains(query)) // 제목 검색
                .filter(post -> place == null || post.getPlace().equals(place)) // 장소 필터
                .filter(post -> tag == null || post.getTags().stream()
                        .anyMatch(t -> t.getTagText().equals(tag))) // 태그 필터
                .filter(post -> category == null || post.getCategories().stream()
                        .anyMatch(c -> c.getCategoryText().equals(category))) // 카테고리 필터
                .filter(post -> timeRanges == null || timeRanges.stream().anyMatch(timeRange -> {
                    String[] ranges = timeRange.split(",");
                    String startTimeString = ranges[0].split("-")[0];
                    String endTimeString = ranges[ranges.length-1].split("-")[1];
                    LocalTime start = LocalTime.parse(String.format("%02d:00:00", Integer.parseInt(startTimeString)));
                    LocalTime end = LocalTime.parse(String.format("%02d:00:00", Integer.parseInt(endTimeString)));
                    return !post.getStartTime().isAfter(end) && !post.getEndTime().isBefore(start);
                })) // 시간 필터
                .map(post -> new PostSimpleResponseDTO(
                        post.getPostID(),
                        post.getTitle(),
                        post.getUrl(),
                        post.getCategories().stream()
                                .map(Category::getCategoryText)
                                .collect(Collectors.toList()),
                        post.getPostDate()
                ))
                .collect(Collectors.toList());
    }
}