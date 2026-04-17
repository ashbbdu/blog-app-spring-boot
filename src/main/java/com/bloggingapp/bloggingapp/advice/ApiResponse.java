package com.bloggingapp.bloggingapp.advice;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ApiResponse <T> {
    private String message;
    private T data;
    private ApiError error;
    private LocalDateTime timestamp;


    public ApiResponse () {
        this.timestamp = LocalDateTime.now();
    }
    public ApiResponse (T data , String message) {
        this();
        this.data = data;
        this.message = message;
    }

    public ApiResponse (ApiError error, String message) {
        this();
        this.error = error;
        this.message = message;
    }
}
