package com.exception;

import com.jwt.JwtAuthenticationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage notFoundExceptionHandler(UsernameNotFoundException e, WebRequest request){
        logger.log(Level.WARNING, e.getMessage());

        ErrorMessage errorMessage = new ErrorMessage
                (HttpStatus.NOT_FOUND.value(),
                        new Date(),
                        e.getMessage(),
                        request.getDescription(false));

        return errorMessage;
    }

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
