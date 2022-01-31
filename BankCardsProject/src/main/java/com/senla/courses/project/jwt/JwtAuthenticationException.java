package com.senla.courses.project.jwt;

public class JwtAuthenticationException extends RuntimeException{
    public JwtAuthenticationException(String message) {
        super(message);
    }
}
