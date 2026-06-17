package com.example.AmazoneClone.modul;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "customer_data")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    @Size(min = 7,max = 25)
    private String password;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
