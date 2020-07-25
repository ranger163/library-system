package me.inassar.librarysystem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Ahmed Nassar.
 * Date: 25 Jul, 2020
 * Time: 2:19 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotfoundException extends RuntimeException {
    private String message;
}
