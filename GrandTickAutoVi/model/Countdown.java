package com.example.GrandTickAutoVi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Countdown {
    private long days;
    private long hours;
    private long minute;
    private long seconds;
    private String message;
}
