package com.smartlook.userservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.smartlook.userservice.response.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ReviewException.class)
    public ResponseEntity<ExceptionResponse> handleReviewException(ReviewException re, WebRequest req){
        ExceptionResponse response = new ExceptionResponse(re.getMessage(), req.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionResponse> handleUserException(UserException re, WebRequest req){
        ExceptionResponse response = new ExceptionResponse(re.getMessage(), req.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception re, WebRequest req){
        ExceptionResponse response = new ExceptionResponse(re.getMessage(), req.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
}
