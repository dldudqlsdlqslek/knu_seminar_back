package haedal.j4.knuseminar.Controller;


import haedal.j4.knuseminar.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class TagController {
    private final TagRepository tagRepository;

    @Autowired
    public TagController(TagRepository tagRepository) {

        this.tagRepository = tagRepository;
    }


    //전체 태그 목록 문자열 리스트로 받아오는 GET Method API
    @GetMapping("/tags")
    public ResponseEntity<List<String>> getTags() {
        List<String> tags = tagRepository.findAll().stream()
                .map(tag -> tag.getTagText())
                .collect(Collectors.toList());

        Set<String> set = new HashSet<>(tags);

        List<String> resultTags = new ArrayList<>(set);
        return ResponseEntity.ok(resultTags);
    }
}