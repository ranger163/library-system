package me.inassar.librarysystem.repositories;

import me.inassar.librarysystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ahmed Nassar.
 * Date: 15 Jul, 2020
 * Time: 12:50 PM
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
