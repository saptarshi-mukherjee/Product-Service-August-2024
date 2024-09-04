package com.introduction.ProductServiceAug24.Services;

import com.introduction.ProductServiceAug24.Exceptions.ProductLimitOutOfBoundsException;
import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import com.introduction.ProductServiceAug24.Models.Categories;
import com.introduction.ProductServiceAug24.Models.Product;

import java.util.List;

public interface ProductService {

    public Product getProduct(long id) throws ProductNotFoundExceptions;
    public List<Product> getProductList();
    public Categories getCategories();
    public List<Product> getPopularProducts(int size) throws ProductLimitOutOfBoundsException;
}
