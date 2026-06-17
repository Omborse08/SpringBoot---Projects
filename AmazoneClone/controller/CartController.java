package com.example.AmazoneClone.controller;

import com.example.AmazoneClone.modul.Bill;
import com.example.AmazoneClone.modul.Cart;
import com.example.AmazoneClone.service.CartService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class CartController {
    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody @Valid Cart cart) {
        service.addProductInCart(cart);
        return new ResponseEntity<>("Product Added In Customer's Cart", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> productOfCustomer(@PathVariable int id) {
        return new ResponseEntity<>(service.allAddedProductInCartByCustomerId(id),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateOrder(@RequestBody @Valid Cart cart) {
        service.updateProductInCart(cart,cart.getId());
        return new ResponseEntity<>("Product Updated In Customer's Cart", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrder(@RequestParam int id) {
        service.removeProductFromCart(id);
        return new ResponseEntity<>("Product Removed From Cart", HttpStatus.OK);
    }
}
