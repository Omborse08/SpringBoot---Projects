package com.example.GrandTickAutoVi.globalException;

import com.example.GrandTickAutoVi.globalException.custome.NewsNotFoundException;
import com.example.GrandTickAutoVi.globalException.dto.ExceptionFormat;
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
    public ResponseEntity<Map<String,String>> handler1(MethodArgumentNotValidException e) {
        Map<String,String> map = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String field_name = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            map.put(field_name,message);
        });
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NewsNotFoundException.class)
    public ResponseEntity<ExceptionFormat> handler2(NewsNotFoundException e) {
        ExceptionFormat format = new ExceptionFormat(
                e.getLocalizedMessage(),
                HttpStatus.NOT_FOUND.toString(),
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(format,HttpStatus.NOT_FOUND);
    }
}
