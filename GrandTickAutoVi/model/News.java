package com.example.GrandTickAutoVi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String about;

    @NotNull
    @NotEmpty
    private String image_data;

    private LocalDate date;

    public News(String title, String about, String image_data, LocalDate date) {
        this.title = title;
        this.about = about;
        this.image_data = image_data;
        this.date = date;
    }
}
