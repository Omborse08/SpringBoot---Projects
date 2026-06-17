package com.example.AmazoneClone.modul;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "products_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Column(name = "info")
    private String description;

    @NotNull
    @NotEmpty
    private String image_data;

    private int quantity;

    @Min(3000)
    @Max(300000)
    private int price;

    public Product(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Product(String name, String desc, String image_data, int quantity, int price) {
        this.name = name;
        this.description = desc;
        this.image_data = image_data;
        this.quantity = quantity;
        this.price = price;
    }
}
