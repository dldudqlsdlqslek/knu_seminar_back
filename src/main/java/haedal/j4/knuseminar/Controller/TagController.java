package haedal.j4.knuseminar.Controller;


import haedal.j4.knuseminar.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TagController {
    private final TagRepository tagRepository;

    @Autowired
    public TagController(TagRepository tagRepository) {

        this.tagRepository = tagRepository;
    }

    @GetMapping("/tags")
    public ResponseEntity<List<String>> getTags() {
        List<String> tags = tagRepository.findAll().stream()
                .map(tag -> tag.getTagText())
                .collect(Collectors.toList());

        return ResponseEntity.ok(tags);
    }
}