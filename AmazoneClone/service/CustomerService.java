package com.example.AmazoneClone.service;

import com.example.AmazoneClone.globalException.customeException.CustomerNotFoundException;
import com.example.AmazoneClone.modul.Customer;
import com.example.AmazoneClone.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository repository;
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void addCustomer(Customer customer) {
        repository.save(customer);
    }

    public Customer getCustomerById(int id) {
        Customer customer = repository.findById(id).orElse(null);
        if (customer==null) {
            throw new CustomerNotFoundException("No Customer Available!");
        }
        return customer;
    }

    public void deleteCustomer(int id) {
        Customer customer = repository.findById(id).orElse(null);
        if (customer==null) {
            throw new CustomerNotFoundException("No Customer Available!");
        }
        repository.deleteById(id);
    }

}
