package me.inassar.librarysystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Ahmed Nassar.
 * Date: 25 Jul, 2020
 * Time: 2:42 PM
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private String errorMessage;
}
