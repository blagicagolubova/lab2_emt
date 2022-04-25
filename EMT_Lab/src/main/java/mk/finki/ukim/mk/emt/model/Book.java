package mk.finki.ukim.mk.emt.model;

import lombok.Data;
import mk.finki.ukim.mk.emt.model.enumerations.Category;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    private Author author;

    private Integer availableCopies;
    @Enumerated(value = EnumType.STRING)
    private Category category;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Book() {
    }

    public Book( String name, Author author, Integer availableCopies, Category category) {

        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.category = category;
    }
}

