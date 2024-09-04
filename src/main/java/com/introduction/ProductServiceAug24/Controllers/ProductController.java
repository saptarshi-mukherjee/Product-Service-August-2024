package com.introduction.ProductServiceAug24.Controllers;

import com.introduction.ProductServiceAug24.Exceptions.ProductLimitOutOfBoundsException;
import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import com.introduction.ProductServiceAug24.Models.Categories;
import com.introduction.ProductServiceAug24.Models.Product;
import com.introduction.ProductServiceAug24.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import  com.introduction.ProductServiceAug24.Models.Categories;


import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService prod_serve;



    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long prod_id) throws ProductNotFoundExceptions {
        Product prod=prod_serve.getProduct(prod_id);
        return new ResponseEntity<>(prod, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/category/jewelery")
    public ResponseEntity<List<Product>>  getJeweleries() {
        List<Product> prod_list=prod_serve.getProductList();
        return new ResponseEntity<>(prod_list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/categories")
    public ResponseEntity<Categories> getAllCategories() {
        Categories category=prod_serve.getCategories();
        return new ResponseEntity<>(category, HttpStatusCode.valueOf(200));
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> limitProducts(@RequestParam("limit") int num) throws ProductLimitOutOfBoundsException {
        List<Product> prod_list=prod_serve.getPopularProducts(num);
        return new ResponseEntity<>(prod_list, HttpStatusCode.valueOf(200));
    }
}
