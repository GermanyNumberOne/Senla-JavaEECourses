package com.senla.courses.project.exception;

public class EntityAlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = 2l;

    public EntityAlreadyExistsException(String message){
        super(message);
    }

}
