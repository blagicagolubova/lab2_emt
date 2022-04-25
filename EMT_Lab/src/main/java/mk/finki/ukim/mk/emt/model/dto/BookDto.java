package mk.finki.ukim.mk.emt.model.dto;
import lombok.Data;
import mk.finki.ukim.mk.emt.model.Author;
import mk.finki.ukim.mk.emt.model.enumerations.Category;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Data
public class BookDto {


    private String name;

    private Long author;
    private Integer availableCopies;
    @Enumerated(value = EnumType.STRING)
    private Category category;

    public BookDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
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

    public BookDto( String name, Long author, Integer availableCopies, Category category) {

        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.category = category;
    }
}
