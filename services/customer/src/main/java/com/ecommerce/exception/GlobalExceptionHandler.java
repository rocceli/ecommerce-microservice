package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * @author - artest - 03rd May 2025 
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException e) {
        return ResponseEntity.status( HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler( MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var errors = new HashMap<String, String>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            var field = error.getField();
            var errorMsg = error.getDefaultMessage();
            errors.put(field, errorMsg);
        });

        return ResponseEntity.status( HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }
}
