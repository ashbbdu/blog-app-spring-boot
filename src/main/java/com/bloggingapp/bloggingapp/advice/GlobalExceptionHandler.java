package com.bloggingapp.bloggingapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<ApiError> handleBadRequest (IllegalArgumentException  illegalArgumentException) {
//        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_ACCEPTABLE).message(illegalArgumentException.getMessage()).build();
//        return new ResponseEntity<>(apiError , HttpStatus.NOT_ACCEPTABLE);
//    }


    @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<ApiResponse<?>> handleBadRequest (IllegalArgumentException  illegalArgumentException) {
            ApiError apiError = ApiError.builder().status(HttpStatus.BAD_REQUEST).message(illegalArgumentException.getMessage()).build();
            return new ResponseEntity<>(new ApiResponse<>(apiError , apiError.getMessage()) , apiError.getStatus());
        }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Validation failed")
                .errors(errors)
                .build();

        return new ResponseEntity<>(new ApiResponse<>(apiError, apiError.getMessage()), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(IllegalArgumentException.class)
//
//    public ResponseEntity<ApiResponse<?>> buildErrorResponseEntity (ApiError apiError) {
//        return new ResponseEntity<>(new ApiResponse<>(apiError , apiError.getMessage()) , apiError.getStatus());
//    }
}
