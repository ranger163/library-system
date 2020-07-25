package me.inassar.librarysystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Ahmed Nassar.
 * Date: 15 Jul, 2020
 * Time: 11:47 AM
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private int age;
    private String name;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Book> rentedBooks;
}
