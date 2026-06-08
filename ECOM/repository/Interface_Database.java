package com.example.ECOM.repository;

import com.example.ECOM.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Interface_Database extends JpaRepository<Product,Integer> {
}
