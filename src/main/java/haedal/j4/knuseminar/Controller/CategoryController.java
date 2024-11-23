package haedal.j4.knuseminar.Controller;


import haedal.j4.knuseminar.Domain.Category;
import haedal.j4.knuseminar.Repository.CategoryRepository;
import haedal.j4.knuseminar.Service.FilterService;
import haedal.j4.knuseminar.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
        return ResponseEntity.ok(categories);
    }

}
