package mk.finki.ukim.mk.emt.service;

import mk.finki.ukim.mk.emt.model.Book;
import mk.finki.ukim.mk.emt.model.dto.BookDto;
import mk.finki.ukim.mk.emt.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    //Book save(String name, Author author, Integer avaliableCopies, Category category);

    //  Optional<Book> edit(String name, Author author, Integer avaliableCopies, Category category);

    void deleteById(Long id);
    boolean markedAsTaken(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);
    List<Category> listCategories ();
}
