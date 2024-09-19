package com.introduction.ProductServiceAug24.Cardinalities.ManyToMany;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity(name = "cart_products")
@Data
public class ProductInCart {
    @Id
    long id;
    String product_name;
//    @ManyToMany
//    List<CartOfUser> cart; // Not necessary
}
