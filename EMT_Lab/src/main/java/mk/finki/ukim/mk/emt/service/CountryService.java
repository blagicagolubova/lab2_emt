package mk.finki.ukim.mk.emt.service;

import mk.finki.ukim.mk.emt.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> findByName(String name);

    Optional<Country> save(String name, String continent);


    void deleteById(Long id);


}

