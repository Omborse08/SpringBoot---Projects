package com.example.GrandTickAutoVi.globalException.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ExceptionFormat {
    private String message;
    private String status;
    private LocalDateTime dateTime;
    private int number;
}
