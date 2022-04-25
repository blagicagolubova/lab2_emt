package mk.finki.ukim.mk.emt.service.impl;

import mk.finki.ukim.mk.emt.model.Author;
import mk.finki.ukim.mk.emt.model.Book;
import mk.finki.ukim.mk.emt.model.dto.AuthorDto;
import mk.finki.ukim.mk.emt.model.exceptions.AuthorNotFoundException;
import mk.finki.ukim.mk.emt.repository.AuthorRepository;
import mk.finki.ukim.mk.emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }


    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Author author = new Author(authorDto.getName(),authorDto.getSurname(),authorDto.getCountry());

        authorRepository.save(author);
        return Optional.of(author);





    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
