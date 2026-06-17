package com.example.AmazoneClone.modul;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Bill {
    private List<Cart> cart;
    private int total_amount;

    public Bill(List<Cart> cart) {
        this.cart = cart;
        this.total_amount = calculateTotal();
    }

    public int calculateTotal() {
        int total_amount = cart.stream().
                mapToInt(c -> c.getQuanitity() * c.getProduct_price())
                .sum();
        return total_amount;
    }
}

