package com.cts.exceptions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomGlobalExceptionHandler {
    
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        // Get all errors
        ex.getBindingResult().getAllErrors().forEach(error -> {
            body.put(((FieldError) error).getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmployeeNotFound.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotFound(EmployeeNotFound exception, WebRequest webRequest) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setStatus(404);
        exceptionResponse.setTime(LocalTime.now());
        exceptionResponse.setDate(LocalDate.now());
        exceptionResponse.setMessage(exception.getMessage());

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidEmployeeIdException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidEmployeeIdException(InvalidEmployeeIdException exception, WebRequest webRequest) {

    	ExceptionResponse exceptionResponse = new ExceptionResponse(); // Changed from EmployeeIdResponse to ExceptionResponse
        exceptionResponse.setStatus(400);
        exceptionResponse.setTime(LocalTime.now());
        exceptionResponse.setDate(LocalDate.now());
        exceptionResponse.setMessage(exception.getMessage());

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponse> handleGenericException(Exception exception, WebRequest webRequest) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setStatus(500); // Changed to 500 for generic exceptions
        exceptionResponse.setTime(LocalTime.now());
        exceptionResponse.setDate(LocalDate.now());
        exceptionResponse.setMessage(exception.getMessage());

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
