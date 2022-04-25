package mk.finki.ukim.mk.emt.service.impl;

import mk.finki.ukim.mk.emt.model.Author;
import mk.finki.ukim.mk.emt.model.Book;
import mk.finki.ukim.mk.emt.model.dto.BookDto;
import mk.finki.ukim.mk.emt.model.enumerations.Category;
import mk.finki.ukim.mk.emt.model.exceptions.AuthorNotFoundException;
import mk.finki.ukim.mk.emt.model.exceptions.BookNotFoundException;
import mk.finki.ukim.mk.emt.repository.AuthorRepository;
import mk.finki.ukim.mk.emt.repository.BookRepository;
import mk.finki.ukim.mk.emt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public boolean markedAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Integer copies = book.getAvailableCopies();
        if (copies != 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        } else {return true;}
        if(copies!=book.getAvailableCopies()) {
            this.bookRepository.save(book);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {

        this.bookRepository.deleteByName(bookDto.getName());
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        Book book = new Book(bookDto.getName(), author , bookDto.getAvailableCopies(),bookDto.getCategory());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        book.setAuthor(author);

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public List<Category> listCategories() {
        List<Category> enumValues = new ArrayList<>(EnumSet.allOf(Category.class));
        return enumValues;
    }


}
