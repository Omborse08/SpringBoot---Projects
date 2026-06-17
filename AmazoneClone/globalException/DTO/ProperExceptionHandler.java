package com.example.AmazoneClone.globalException.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class ProperExceptionHandler {
    private String message;
    private LocalDateTime dateTime;
    private String status;

    public ProperExceptionHandler(String message, LocalDateTime dateTime, String status) {
        this.message = message;
        this.dateTime = dateTime;
        this.status = status;
    }
}
