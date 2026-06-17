package com.example.AmazoneClone.repository;

import com.example.AmazoneClone.modul.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
