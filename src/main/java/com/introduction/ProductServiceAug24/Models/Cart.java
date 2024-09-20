package com.introduction.ProductServiceAug24.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name="carts")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String user_name;
    @ManyToMany
    List<Product> products=new ArrayList<>();
}
