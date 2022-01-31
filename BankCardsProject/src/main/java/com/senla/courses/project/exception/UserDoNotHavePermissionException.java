package com.senla.courses.project.exception;

public class UserDoNotHavePermissionException extends RuntimeException{
    private static final long serialVersionUID = 3l;

    public UserDoNotHavePermissionException(String message){
        super(message);
    }
}
