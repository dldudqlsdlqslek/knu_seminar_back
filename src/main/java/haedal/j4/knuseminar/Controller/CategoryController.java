package haedal.j4.knuseminar.Controller;


import haedal.j4.knuseminar.Repository.CategoryRepository;
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
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }



    //카테고리 전체 문자열 리스트로 받아오는 GET method API
    @GetMapping("/categories")
    public ResponseEntity<List<String>> getCategories() {
        List<String> categories = categoryRepository.findAll().stream()
                .map(category -> category.getCategoryText())
                .collect(Collectors.toList());
        Set<String> set = new HashSet<>(categories);

        List<String> resultCategories = new ArrayList<>(set);
        return ResponseEntity.ok(resultCategories);
    }

}
