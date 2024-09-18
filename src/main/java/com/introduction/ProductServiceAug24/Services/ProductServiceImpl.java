package com.introduction.ProductServiceAug24.Services;

import com.introduction.ProductServiceAug24.Exceptions.InvalidSortingException;
import com.introduction.ProductServiceAug24.Exceptions.ProductLimitOutOfBoundsException;
import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import com.introduction.ProductServiceAug24.Models.Categories;
import com.introduction.ProductServiceAug24.Models.Product;
import com.introduction.ProductServiceAug24.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("custom DB service")
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository prod_repo;

    @Override
    public Product getProduct(Long id) throws ProductNotFoundExceptions {
        return null;
    }

    @Override
    public List<Product> getProductList() {
        return List.of();
    }

    @Override
    public Categories getCategories() {
        return null;
    }

    @Override
    public List<Product> getPopularProducts(int size) throws ProductLimitOutOfBoundsException {
        return List.of();
    }

    @Override
    public List<Product> sortProducts(String sort_type) throws InvalidSortingException {
        return List.of();
    }

    @Override
    public Product createProduct(String name, String category, String description) {
        Product product=new Product();
        product.setName(name);
        product.setCategory(category);
        product.setDescription(description);
        product=prod_repo.save(product);
        return product;
    }

    @Override
    public Product getProductFromDBById(long id) {
        //Product product=new Product();
        Product product=prod_repo.fetchProductById(id);
        return product;
    }

    @Override
    public List<Product> getAllProductsFromDB() {
        List<Product> prod_list=prod_repo.fetchAllProducts();
        return prod_list;
    }
}
