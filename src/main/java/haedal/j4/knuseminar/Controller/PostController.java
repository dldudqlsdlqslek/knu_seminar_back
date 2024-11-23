package haedal.j4.knuseminar.Controller;

import haedal.j4.knuseminar.ResponseDTO.PostSimpleResponseDTO;
import haedal.j4.knuseminar.Service.FilterService;
import haedal.j4.knuseminar.Service.PostService;
import haedal.j4.knuseminar.Service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    private final FilterService filterService;
    private final PostService postService;
    private final SearchService searchService;

    @Autowired
    public PostController(FilterService filterService, PostService postService, SearchService searchService) {
        this.filterService = filterService;
        this.postService = postService;
        this.searchService = searchService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostSimpleResponseDTO>> getPosts() {
        List<PostSimpleResponseDTO> postlist = postService.getAllPosts();
        return ResponseEntity.ok(postlist);
    }


}
