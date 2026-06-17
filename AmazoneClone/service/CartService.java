package com.example.AmazoneClone.service;

import com.example.AmazoneClone.globalException.customeException.CustomerNotFoundException;
import com.example.AmazoneClone.globalException.customeException.OrderNotFoundException;
import com.example.AmazoneClone.globalException.customeException.ProductNotFoundException;
import com.example.AmazoneClone.modul.Bill;
import com.example.AmazoneClone.modul.Cart;
import com.example.AmazoneClone.modul.Product;
import com.example.AmazoneClone.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository repository;
    private final CustomerService customerService;
    private final ProductService productService;
    @Autowired
    public CartService(CartRepository repository, CustomerService customerService, ProductService productService) {
        this.repository = repository;
        this.customerService = customerService;
        this.productService = productService;
    }


    public void addProductInCart(Cart cart) {
        if (customerService.getCustomerById(cart.getCustomerId())==null) {
            throw new CustomerNotFoundException("Customer Not Available!");
        }
        Product product = productService.getById(cart.getProduct_id());
        if (product==null) {
            throw new ProductNotFoundException("Product Not Found!");
        }

        if (product.getQuantity()<cart.getQuanitity()) {
            throw new ProductNotFoundException("There is Only "+product.getQuantity()+" Quantity Available!");
        }

        product.setQuantity(product.getQuantity()-cart.getQuanitity());
        productService.updateProduct(product,cart.getProduct_id());

        cart.setProduct_price(product.getPrice());
        cart.setImage_data(product.getImage_data());

        cart.setId(cart.getId());
        cart.setImage_data(product.getImage_data());
        cart.setProduct_price(product.getPrice());
        repository.save(cart);
    }

    public void updateProductInCart(Cart cart,int id) {
        Cart cart1 = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Error"));

        Product product = productService.getById(cart.getProduct_id());

        int oldQuantity = cart1.getQuanitity();
        int newQuantity = cart.getQuanitity();
        int total = newQuantity - oldQuantity;

        if (total > 0 && product.getQuantity() < total) {
            throw new ProductNotFoundException("There is only "+ product.getQuantity() +" more quantity available!");
        }

        int updatedQuantity = product.getQuantity() - total;

        if (updatedQuantity < 0) {
            throw new ProductNotFoundException("Not enough stock available");
        }
        if (cart.getQuanitity() > 30) {
            throw new ProductNotFoundException("Product Cannot Be Added!");
        }

        product.setQuantity(updatedQuantity);
        productService.updateProduct(product,cart.getProduct_id());

        repository.save(cart);
    }

    public void removeProductFromCart(int id) {
        Cart cart = repository.findById(id).orElse(null);
        if (cart==null) {
            throw new OrderNotFoundException("No Order Available!");
        }
        Product product = productService.getById(cart.getProduct_id());
        product.setQuantity(product.getQuantity()+cart.getQuanitity());
        repository.deleteById(id);
    }

    public Bill allAddedProductInCartByCustomerId(int id) {
        if (customerService.getCustomerById(id)==null) {
            throw new CustomerNotFoundException("Customer Not Found!");
        }
        return new Bill(repository.findByCustomerId(id));
    }

}
