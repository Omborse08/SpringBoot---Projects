package com.example.AmazoneClone.repository;

import com.example.AmazoneClone.modul.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findByCustomerId(int customerId);
}
