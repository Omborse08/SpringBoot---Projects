package com.example.AmazoneClone.controller;

import com.example.AmazoneClone.modul.Product;
import com.example.AmazoneClone.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<String> addProduct(@RequestBody @Valid Product product) {
        service.addProduct(product);
        return new ResponseEntity<>("Product Added!", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        Product product = service.getById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<String> updateById(@RequestBody @Valid Product product) {
        service.updateProduct(product,product.getId());
        return new ResponseEntity<>("Product Updated Successfully!",HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteById(@RequestParam int id) {
        service.deleteById(id);
        return new ResponseEntity<>("Product Deleted Successfully!",HttpStatus.OK);
    }

}
