package mk.finki.ukim.mk.emt.model;


import lombok.Data;
import mk.finki.ukim.mk.emt.model.enumerations.Role;

import javax.persistence.*;

@Data
@Entity
@Table(name="library_users")
public class User {
    @Id
    private String username;
    private String name;
    private String surname;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User() {
    }

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
}
