package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LikeNotFoundException.class)
    ResponseEntity<ApiError> likeNotFoundHandler(Exception exception, ServletWebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setMessage(exception.getLocalizedMessage());
        apiError.setCode(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }



}