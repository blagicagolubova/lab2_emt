package mk.finki.ukim.mk.emt.service;

import mk.finki.ukim.mk.emt.model.Author;
import mk.finki.ukim.mk.emt.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);

    List<Author> findAll();

    //Author save(String name, String surname, Country country);
    Optional<Author> save(AuthorDto authorDto);
    void deleteById(Long id);
}

