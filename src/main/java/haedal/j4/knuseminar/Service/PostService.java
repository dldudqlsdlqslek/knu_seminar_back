package haedal.j4.knuseminar.Service;


import haedal.j4.knuseminar.Domain.Category;
import haedal.j4.knuseminar.Domain.Post;
import haedal.j4.knuseminar.Repository.PostRepository;
import haedal.j4.knuseminar.ResponseDTO.PostSimpleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostSimpleResponseDTO> getAllPosts(Integer postID) {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> new PostSimpleResponseDTO(
                        post.getPostID(),
                        post.getTitle(),
                        post.getCategories().stream()
                                .map(category::getCategoryText)  // Category의 이름을 리스트로 변환
                                .collect(Collectors.toList()),
                        post.getPostDate()))
                .collect(Collectors.toList());

    }
}
