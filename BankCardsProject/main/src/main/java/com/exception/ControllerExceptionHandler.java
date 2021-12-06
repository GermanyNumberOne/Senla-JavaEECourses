package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class ControllerExceptionHandler {
    private final Logger logger = Logger.getLogger(ControllerExceptionHandler.class.getName());
/*
    @ExceptionHandler(EntityAlreadyExists.class)
    @ResponseStatus(value = HttpStatus.)
*/
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ErrorMessage noResultExceptionHandler(NoResultException e, WebRequest request){
        logger.log(Level.WARNING, e.getMessage());

        ErrorMessage errorMessage = new ErrorMessage
                (HttpStatus.NO_CONTENT.value(),
                        new Date(),
                        e.getMessage(),
                        request.getDescription(false));

        return errorMessage;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ErrorMessage entityNotFoundExceptionHandler(EntityNotFoundException e, WebRequest request){
        logger.log(Level.WARNING, e.getMessage());

        ErrorMessage errorMessage = new ErrorMessage
                        (HttpStatus.NO_CONTENT.value(),
                        new Date(),
                        e.getMessage(),
                        request.getDescription(false));

        return errorMessage;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception e, WebRequest request){
        logger.log(Level.WARNING, e.getMessage());

        ErrorMessage errorMessage = new ErrorMessage
                (HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        new Date(),
                        e.getMessage(),
                        request.getDescription(false));

        return errorMessage;
    }
}
