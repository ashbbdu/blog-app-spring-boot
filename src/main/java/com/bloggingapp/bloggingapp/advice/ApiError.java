package com.bloggingapp.bloggingapp.advice;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Builder
@Data
public class ApiError {
    private HttpStatus status;
    private String message;
    private Map<String, String> errors;
}
