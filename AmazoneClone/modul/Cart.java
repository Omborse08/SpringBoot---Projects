package com.example.AmazoneClone.modul;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_table")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_id")
    private int customerId;
    private int product_id;
    private int product_price;
    private int quanitity;

    private String image_data;

    public Cart(int customer_id, int product_id, int quanitity) {
        this.customerId = customer_id;
        this.product_id = product_id;
        this.quanitity = quanitity;
    }

    public Cart(int id, int customer_id, int product_id, int quanitity) {
        this.id = id;
        this.customerId = customer_id;
        this.product_id = product_id;
        this.quanitity = quanitity;
    }
}
