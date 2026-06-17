package com.example.AmazoneClone.controller;

import com.example.AmazoneClone.modul.Customer;
import com.example.AmazoneClone.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody @Valid Customer customer) {
        service.addCustomer(customer);
        return new ResponseEntity<>("Customer Added!", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestParam int id) {
        service.deleteCustomer(id);
        return new ResponseEntity<>("Customer Deleted!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        return new ResponseEntity<>(service.getCustomerById(id), HttpStatus.OK);
    }
}
