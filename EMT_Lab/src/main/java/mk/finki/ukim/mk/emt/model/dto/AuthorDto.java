package mk.finki.ukim.mk.emt.model.dto;

import mk.finki.ukim.mk.emt.model.Country;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class AuthorDto {


    private String name;
    private String surname;

    private Country country;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public AuthorDto() {
    }

    public AuthorDto (String name, String surname, Country country) {

        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}


