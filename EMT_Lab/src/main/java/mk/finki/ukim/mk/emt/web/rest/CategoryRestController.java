package mk.finki.ukim.mk.emt.web.rest;

import mk.finki.ukim.mk.emt.model.enumerations.Category;
import mk.finki.ukim.mk.emt.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/categories")
public class CategoryRestController {
    private final BookService bookService;

    public CategoryRestController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    private List<Category> listCategories() {
        return this.bookService.listCategories();
    }
}
