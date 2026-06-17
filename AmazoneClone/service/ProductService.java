package com.example.AmazoneClone.service;

import com.example.AmazoneClone.globalException.customeException.ProductNotFoundException;
import com.example.AmazoneClone.modul.Product;
import com.example.AmazoneClone.repository.ProductRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRespository respository;

    public ProductService(ProductRespository respository) {
        this.respository = respository;
    }

    public void addProduct(Product product) {
        respository.save(product);
    }

    public void updateProduct(Product product,int id) {
        if (respository.findById(id).orElse(null)==null) {
            throw new ProductNotFoundException("Product not available!");
        }
        respository.save(product);
    }

    public List<Product> getAllProducts() {
        return respository.findAll();
    }

    public Product getById(int id) {
        return respository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        if (respository.findById(id).orElse(null)==null) {
            throw new ProductNotFoundException("Product not available!");
        }
        respository.deleteById(id);
    }
}
