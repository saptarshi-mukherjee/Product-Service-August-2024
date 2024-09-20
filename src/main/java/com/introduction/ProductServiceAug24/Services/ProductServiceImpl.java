package com.introduction.ProductServiceAug24.Services;

import com.introduction.ProductServiceAug24.DTO.NameAndIdResponseDto;
import com.introduction.ProductServiceAug24.DTO.UserAndProductDto;
import com.introduction.ProductServiceAug24.Exceptions.InvalidSortingException;
import com.introduction.ProductServiceAug24.Exceptions.ProductLimitOutOfBoundsException;
import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import com.introduction.ProductServiceAug24.Models.Cart;
import com.introduction.ProductServiceAug24.Models.Categories;
import com.introduction.ProductServiceAug24.Models.Product;
import com.introduction.ProductServiceAug24.Projections.NameAndProductInfo;
import com.introduction.ProductServiceAug24.Repositories.CartRepository;
import com.introduction.ProductServiceAug24.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("custom DB service")
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository prod_repo;
    @Autowired
    CartRepository cart_repo;

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
    public Product getProductFromDBById(long id) throws ProductNotFoundExceptions{
        //Product product=new Product();
        Product prod_op=prod_repo.fetchProductById(id);
        if(prod_op!=null)
            return prod_op;
        else
            throw new ProductNotFoundExceptions("Product not present");
    }

    @Override
    public List<Product> getAllProductsFromDB() {
        List<Product> prod_list=prod_repo.fetchAllProducts();
        return prod_list;
    }

    @Override
    public List<String> getAllcategories() {
        List<String> cat_list=prod_repo.fetchAllCategories();
        return cat_list;
    }

    @Override
    public List<NameAndIdResponseDto> getNameAndId(String name) {
        List<NameAndIdResponseDto> response_list=new ArrayList<>();
        List<Object[]> result=prod_repo.fetchNameAndId(name);
        for(Object[] row : result) {
            NameAndIdResponseDto entry=new NameAndIdResponseDto();
            entry.setId((Long)row[0]);
            entry.setName((String)row[1]);
            response_list.add(entry);
        }
        return response_list;
    }

    @Override
    public Product updateProduct(String name, String category, String description, long id) {
        Product product=prod_repo.fetchProductById(id);
        product.setName(name);
        product.setDescription(description);
        product.setCategory(category);
        product = prod_repo.save(product);
        return product;
    }

    @Override
    public List<Product> deleteProductById(long id) {
        Product prod_op=prod_repo.fetchProductById(id);
        prod_repo.delete(prod_op);
        List<Product> prod_list=prod_repo.fetchAllProducts();
        return prod_list;
    }

    @Override
    public Cart createCart(String user_name, long prod_id) {
        Product product=getProductById(prod_id);
        Cart cart=new Cart();
        cart.setUser_name(user_name);
        cart.getProducts().add(product);
        cart=cart_repo.save(cart);
        return cart;
    }

    @Override
    public Product getProductById(long id) {
        return prod_repo.fetchProductById(id);
    }

    @Override
    public Cart getCartById(long id) {
        return cart_repo.fetchCartById(id);
    }

    @Override
    public NameAndProductInfo getUserAndProduct(long cart_id) {
        NameAndProductInfo info=cart_repo.fetchUserAndProduct(cart_id);
        return info;
    }
}
