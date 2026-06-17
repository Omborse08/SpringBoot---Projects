package com.example.AmazoneClone.globalException;

import com.example.AmazoneClone.globalException.DTO.ProperExceptionHandler;
import com.example.AmazoneClone.globalException.customeException.CustomerNotFoundException;
import com.example.AmazoneClone.globalException.customeException.OrderNotFoundException;
import com.example.AmazoneClone.globalException.customeException.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArguNotValidException(MethodArgumentNotValidException e) {
        Map<String,String> hashmap = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            hashmap.put(fieldName,message);
        });
        return new ResponseEntity<>(hashmap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProperExceptionHandler> productNotFoundException(ProductNotFoundException e) {
        ProperExceptionHandler exceptionHandler = new ProperExceptionHandler(
                e.getLocalizedMessage(),
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.toString()
        );
        return new ResponseEntity<>(exceptionHandler,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ProperExceptionHandler> customerNotFoundException(CustomerNotFoundException e) {
        ProperExceptionHandler exceptionHandler = new ProperExceptionHandler(
                e.getLocalizedMessage(),
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.toString()
        );
        return new ResponseEntity<>(exceptionHandler,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ProperExceptionHandler> orderNotFoundException(OrderNotFoundException e) {
        ProperExceptionHandler properExceptionHandler = new ProperExceptionHandler(
                e.getLocalizedMessage(),
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.toString()
        );
        return new ResponseEntity<>(properExceptionHandler,HttpStatus.NOT_FOUND);
    }
}
