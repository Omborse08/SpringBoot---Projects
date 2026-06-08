package com.example.ECOM.controller;


import com.example.ECOM.model.Product;
import com.example.ECOM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/ALL")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(service.getAllProduct(),HttpStatus.OK);
    }

    @PostMapping("/SEND")
    public String add(@RequestBody Product product) {
        service.addProduct(product);
        return "Product Added!";
    }

    @GetMapping("/GET/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        Product product = service.getProductById(id);
        if (product!=null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/DEL/{id}")
    public String removeProduct(@PathVariable int id) {
        Product product = service.getProductById(id);
        if (product!=null) {
            service.removeProducts(id);
            return "Removed!";
        }
        return "Not Removed!";
    }

    @PutMapping("/PUT")
    public String update(@RequestBody Product product) {
        Product product1 = service.getProductById(product.getId());
        if (product1!=null) {
            service.updateProduct(product);
            return "Updated";
        }
        return "Not Updated";
    }
}
