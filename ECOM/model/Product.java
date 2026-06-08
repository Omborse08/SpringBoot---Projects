package com.example.ECOM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String decs;
    private int price;
    private int quantity;
    private LocalDate localDate = LocalDate.now();

    public Product(String title, String decs, int price, int quantity) {
        this.title = title;
        this.decs = decs;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int id, String title, String decs, int price, int quantity) {
        this.id = id;
        this.title = title;
        this.decs = decs;
        this.price = price;
        this.quantity = quantity;
    }
}
