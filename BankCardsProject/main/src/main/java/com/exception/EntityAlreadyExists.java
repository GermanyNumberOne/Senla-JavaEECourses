package com.exception;

public class EntityAlreadyExists extends RuntimeException{
    private static final long serialVersionUID = 2l;

    public EntityAlreadyExists(String message){
        super(message);
    }

}
