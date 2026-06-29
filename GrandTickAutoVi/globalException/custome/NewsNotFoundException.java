package com.example.GrandTickAutoVi.globalException.custome;

public class NewsNotFoundException extends RuntimeException{
    public NewsNotFoundException(String message) {
        super(message);
    }
}
