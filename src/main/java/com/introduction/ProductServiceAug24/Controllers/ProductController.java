package com.introduction.ProductServiceAug24.Controllers;

import com.introduction.ProductServiceAug24.Models.Categories;
import com.introduction.ProductServiceAug24.Models.Product;
import com.introduction.ProductServiceAug24.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
//import  com.introduction.ProductServiceAug24.Models.Categories;


import java.util.*;

@RestController
public class ProductController {
    @Autowired
    ProductService prod_serve;



    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long prod_id) {
        if(prod_id<1 || prod_id>20) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        Product prod=prod_serve.getProduct(prod_id);
        return new ResponseEntity<>(prod, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/products/category/jewelery")
    public ResponseEntity<List<Product>>  getJeweleries() {
        List<Product> prod_list=prod_serve.getProductList();
        return new ResponseEntity<>(prod_list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/products/categories")
    public ResponseEntity<Categories> getAllCategories() {
        Categories category=prod_serve.getCategories();
        return new ResponseEntity<>(category, HttpStatusCode.valueOf(200));
    }
}
