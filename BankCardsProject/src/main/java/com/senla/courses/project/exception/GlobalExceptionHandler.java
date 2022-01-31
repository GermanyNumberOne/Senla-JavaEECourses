package com.senla.courses.project.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.NoResultException;
import java.util.Date;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage alreadyExistException(EntityAlreadyExistsException e, WebRequest request){
        log.warn(e.getMessage());

        ErrorMessage errorMessage = new ErrorMessage
                (HttpStatus.CONFLICT.value(),
                        new Date(),
                        e.getMessage(),
                        request.getDescription(false));

        return errorMessage;
    }

    @ExceptionHandler(UserDoNotHavePermissionException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorMessage notFoundExceptionHandler(UserDoNotHavePermissionException e, WebRequest request){
        log.warn(e.getMessage());

        ErrorMessage errorMessage = new ErrorMessage
                (HttpStatus.FORBIDDEN.value(),
                        new Date(),
                        e.getMessage(),
                        request.getDescription(false));

        return errorMessage;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage notFoundExceptionHandler(UsernameNotFoundException e, WebRequest request){
        log.warn(e.getMessage());

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
        log.warn(e.getMessage());

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
        log.warn(e.getMessage());

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
        log.warn(e.getMessage());

        ErrorMessage errorMessage = new ErrorMessage
                (HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        new Date(),
                        e.getMessage(),
                        request.getDescription(false));

        return errorMessage;
    }
}
