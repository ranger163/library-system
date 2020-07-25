package me.inassar.librarysystem.repositories;

import me.inassar.librarysystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ahmed Nassar.
 * Date: 15 Jul, 2020
 * Time: 12:49 PM
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
