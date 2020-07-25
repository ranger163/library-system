package me.inassar.librarysystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Ahmed Nassar.
 * Date: 15 Jul, 2020
 * Time: 11:33 AM
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int numberOfAvailableCopies;
    private int numberOfCopies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
