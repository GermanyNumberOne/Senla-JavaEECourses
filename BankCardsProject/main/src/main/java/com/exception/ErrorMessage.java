package com.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorMessage {
    private int statusCode;
    private Date time;
    private String message;
    private String description;

    public ErrorMessage(int statusCode, Date time, String message, String description) {
        this.statusCode = statusCode;
        this.time = time;
        this.message = message;
        this.description = description;
    }
}
