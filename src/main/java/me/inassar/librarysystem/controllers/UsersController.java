package me.inassar.librarysystem.controllers;

import me.inassar.librarysystem.exceptions.NotfoundException;
import me.inassar.librarysystem.models.Book;
import me.inassar.librarysystem.models.User;
import me.inassar.librarysystem.repositories.BookRepository;
import me.inassar.librarysystem.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ahmed Nassar.
 * Date: 15 Jul, 2020
 * Time: 12:56 PM
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    UserRepository userRepository;
    BookRepository bookRepository;

    /**
     * This is a constructor autowiring
     *
     * @param userRepository
     * @param bookRepository
     */
    public UsersController(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    /**
     * This method is used to save a single user to the h2 database
     *
     * @param user
     * @return {@link User}
     */
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * This method is used to save list of users to the h2 database
     *
     * @param users
     * @return {@link List<User>}
     */
    @PostMapping("/saveUsers")
    public List<User> saveUsers(@RequestBody List<User> users) {
        return userRepository.saveAll(users);
    }

    /**
     * This method is used to fetch list of users from the h2 database
     *
     * @return {@link List<User>}
     */
    @GetMapping("/getUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * This method is used to fetch list of books rented by specific user id from the h2 database
     *
     * @param userId
     * @return {@link List<Book>}
     */
    @GetMapping("/user/{userId}/books")
    public List<Book> getRentedBooksByUserId(@PathVariable Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new NotfoundException("User with ID: " + userId + " Not found");
        }
        return userOptional.get().getRentedBooks();
    }

    /**
     * This method is used to rent a single book by user id
     *
     * @param userId
     * @param book
     * @return {@link ResponseEntity<Object>}
     */
    @PostMapping("/user/{userId}/rentBook")
    public ResponseEntity<Object> rentSingleBook(@PathVariable Long userId, @RequestBody Book book) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new NotfoundException("User with ID: " + userId + " Not found");
        }
        book.setUser(userOptional.get());
        bookRepository.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}