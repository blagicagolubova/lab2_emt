package mk.finki.ukim.mk.emt.config;

import mk.finki.ukim.mk.emt.model.Author;
import mk.finki.ukim.mk.emt.model.Country;
import mk.finki.ukim.mk.emt.model.dto.AuthorDto;
import mk.finki.ukim.mk.emt.model.dto.BookDto;
import mk.finki.ukim.mk.emt.model.enumerations.Category;
import mk.finki.ukim.mk.emt.service.AuthorService;
import mk.finki.ukim.mk.emt.service.BookService;
import mk.finki.ukim.mk.emt.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
public class DataInitializer {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public DataInitializer(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData(){
        Country country = new Country();
        Author author = new Author();
        for (int i = 0; i< 5; i++){
            country = this.countryService.save("name", "continent").get();
            }
        for (int i = 0; i< 5; i++){
            author = this.authorService.save(new AuthorDto("author", "surname", country )).get();

        }
        this.bookService.save(new BookDto("book name", author.getId(), 10, Category.DRAMA));

    }
}
