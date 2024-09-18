package com.introduction.ProductServiceAug24.Controllers;

import com.introduction.ProductServiceAug24.DTO.PostProductRequestDto;
import com.introduction.ProductServiceAug24.Exceptions.InvalidSortingException;
import com.introduction.ProductServiceAug24.Exceptions.ProductLimitOutOfBoundsException;
import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import com.introduction.ProductServiceAug24.Models.Categories;
import com.introduction.ProductServiceAug24.Models.Product;
import com.introduction.ProductServiceAug24.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import  com.introduction.ProductServiceAug24.Models.Categories;


import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    @Qualifier("custom DB service")
    ProductService prod_serve;



    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id", required = false) Long prod_id) throws ProductNotFoundExceptions {
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
    public ResponseEntity<List<Product>> getSortedOrLimitedProducts(@RequestParam(value = "limit", required = false) Integer limit,
                                                                    @RequestParam(value = "sort", required = false) String sort_type)
                                                                    throws ProductLimitOutOfBoundsException, InvalidSortingException {
        List<Product> prod_list=null;
        if(sort_type==null) {
            prod_list=prod_serve.getPopularProducts(limit);
            return new ResponseEntity<List<Product>>(prod_list, HttpStatusCode.valueOf(200));
        }
        else {
            prod_list=prod_serve.sortProducts(sort_type);
            return new ResponseEntity<List<Product>>(prod_list, HttpStatusCode.valueOf(200));
        }
    }

    @PostMapping("")
    public Product createNewProduct(@RequestBody PostProductRequestDto post_request) {
        return prod_serve.createProduct(post_request.getName(), post_request.getCategory(), post_request.getDescription());
    }

    @GetMapping("/db/{id}")
    public Product getDBProductById(@PathVariable("id") long id) {
        return null;
    }
}
