package me.inassar.librarysystem.exceptions;

import me.inassar.librarysystem.models.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ahmed Nassar.
 * Date: 25 Jul, 2020
 * Time: 2:21 PM
 */
@ControllerAdvice
public class NotFoundExceptionController {

    /**
     * This method is used to return exception error message
     *
     * @param exception
     * @return {@link ExceptionResponse}
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NotfoundException.class)
    public ExceptionResponse exception(NotfoundException exception) {
        return new ExceptionResponse(exception.getMessage());
    }
}
