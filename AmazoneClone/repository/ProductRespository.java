package com.example.AmazoneClone.repository;

import com.example.AmazoneClone.modul.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespository extends JpaRepository<Product,Integer> {
}
