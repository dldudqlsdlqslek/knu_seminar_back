package haedal.j4.knuseminar.Controller;

import haedal.j4.knuseminar.ResponseDTO.PostDetailResponseDTO;
import haedal.j4.knuseminar.ResponseDTO.PostSimpleResponseDTO;
import haedal.j4.knuseminar.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostSimpleResponseDTO>> getPosts() {
        List<PostSimpleResponseDTO> postlist = postService.getAllPosts();
        return ResponseEntity.ok(postlist);
    }

    @GetMapping("/posts/{postID}")
    public ResponseEntity<PostDetailResponseDTO> getPost(@PathVariable Integer postID) {
        PostDetailResponseDTO postDetails = postService.getPostsDetails(postID);
        return ResponseEntity.ok(postDetails);
    }

    @GetMapping("/posts/search")
    public ResponseEntity<List<PostSimpleResponseDTO>> searchPosts(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) List<String> time, // time ranges
            @RequestParam(required = false) String place,
            @RequestParam(required = false) String tag,
            @RequestParam(required = false) String category
    ){
        List<PostSimpleResponseDTO> searchPostlist = postService.postSearch(query, time, place, tag, category);
        return ResponseEntity.ok(searchPostlist);
    }

}
