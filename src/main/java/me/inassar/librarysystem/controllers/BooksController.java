package me.inassar.librarysystem.controllers;

import me.inassar.librarysystem.exceptions.NotfoundException;
import me.inassar.librarysystem.models.Book;
import me.inassar.librarysystem.models.User;
import me.inassar.librarysystem.repositories.BookRepository;
import me.inassar.librarysystem.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Ahmed Nassar.
 * Date: 15 Jul, 2020
 * Time: 5:40 PM
 */
@RestController
@RequestMapping("/books")
public class BooksController {

    UserRepository userRepository;
    BookRepository bookRepository;

    /**
     * This is a constructor autowiring
     *
     * @param userRepository
     * @param bookRepository
     */
    public BooksController(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    /**
     * This method is used to save a single book to the h2 database
     *
     * @param books
     * @return {@link Book}
     */
    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book books) {
        return bookRepository.save(books);
    }

    /**
     * This method is used to save list of books to the h2 database
     *
     * @param books
     * @return {@link List<Book>}
     */
    @PostMapping("/saveBooks")
    public List<Book> saveBooks(@RequestBody List<Book> books) {
        return bookRepository.saveAll(books);
    }

    /**
     * This method is used to fetch list of books from the h2 database
     *
     * @return {@link List<Book>}
     */
    @GetMapping("/getBooks")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * This method is used to get the user who rented that book using book id
     *
     * @param bookId
     * @return {@link User}
     */
    @GetMapping("/{bookId}/user")
    public User getUserOfABook(@PathVariable Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (!bookOptional.isPresent()) {
            throw new NotfoundException("Book with ID: " + bookId + " Not found");
        }
        User user = new User();
        BeanUtils.copyProperties(bookOptional.get().getUser(), user);
        return user;
    }
}