package com.example.ECOM.service;

import com.example.ECOM.model.Product;
import com.example.ECOM.repository.Interface_Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private Interface_Database database;

    public void addProduct(Product product) {
        database.save(product);
    }

    public void removeProducts(int id){
        database.deleteById(id);
    }

    public List getAllProduct() {
        return database.findAll();
    }

    public Product getProductById(int id) {
        return database.findById(id).orElse(null);
    }

    public void updateProduct(Product product) {
        database.save(product);
    }
}
