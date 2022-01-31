package com.senla.courses.project.exception;

public class EntityNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1l;

    public EntityNotFoundException(String message){
        super(message);
    }

}
