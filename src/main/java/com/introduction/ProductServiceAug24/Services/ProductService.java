package com.introduction.ProductServiceAug24.Services;

import com.introduction.ProductServiceAug24.DTO.NameAndIdResponseDto;
import com.introduction.ProductServiceAug24.DTO.UserAndProductDto;
import com.introduction.ProductServiceAug24.Exceptions.InvalidSortingException;
import com.introduction.ProductServiceAug24.Exceptions.ProductLimitOutOfBoundsException;
import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import com.introduction.ProductServiceAug24.Models.Cart;
import com.introduction.ProductServiceAug24.Models.Categories;
import com.introduction.ProductServiceAug24.Models.Product;

import java.util.List;

public interface ProductService {

    public Product getProduct(Long id) throws ProductNotFoundExceptions;
    public List<Product> getProductList();
    public Categories getCategories();
    public List<Product> getPopularProducts(int size) throws ProductLimitOutOfBoundsException;
    public List<Product> sortProducts(String sort_type) throws InvalidSortingException;
    public Product createProduct(String name, String category, String description);
    public Product getProductFromDBById(long id) throws ProductNotFoundExceptions;
    public List<Product> getAllProductsFromDB();
    public List<String> getAllcategories();
    public List<NameAndIdResponseDto> getNameAndId(String name);
    public Product updateProduct(String name, String category, String description, long id);
    public List<Product> deleteProductById(long id);
    public Cart createCart(String user_name, long prod_id);
    public Product getProductById(long id);
    public Cart getCartById(long id);
    public UserAndProductDto getUserAndProduct(long cart_id);
}
