package com.introduction.ProductServiceAug24.Cardinalities.ManyToMany;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity(name = "user_cart")
public class CartOfUser {
    @Id
    long id;
    String user_name;
    @ManyToMany
    List<ProductInCart> product;
}
