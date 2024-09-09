package com.introduction.ProductServiceAug24.Services;

import com.introduction.ProductServiceAug24.DTO.CartDetailsDto;
import com.introduction.ProductServiceAug24.DTO.FakeStoreProductDto;
import com.introduction.ProductServiceAug24.Exceptions.InvalidSortingException;
import com.introduction.ProductServiceAug24.Exceptions.ProductLimitOutOfBoundsException;
import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import com.introduction.ProductServiceAug24.Models.CartInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreCartServices implements CartServices{
    @Override
    public CartInfo cartProducts(int id) throws ProductNotFoundExceptions {
        if(id<1 || id>7)
            throw new ProductNotFoundExceptions("Product ID is invalid");
        String url="https://fakestoreapi.com/carts/"+id;
        RestTemplate rest=new RestTemplate();
        CartDetailsDto cart_prod=rest.getForObject(url,CartDetailsDto.class);
        return convertToCustomCart(cart_prod);
    }

    @Override
    public List<CartInfo> getLimitedCartDetails(Integer limit) throws ProductLimitOutOfBoundsException {
        if(limit<1 || limit>7)
            throw new ProductLimitOutOfBoundsException("Product not found in cart");
        String url="https://fakestoreapi.com/carts?limit="+limit;
        RestTemplate rest=new RestTemplate();
        CartDetailsDto[] fake_prod_list=rest.getForObject(url, CartDetailsDto[].class);
        List<CartInfo> cart_products=new ArrayList<>();
        for(CartDetailsDto cart_prod : fake_prod_list) {
            cart_products.add(convertToCustomCart(cart_prod));
        }
        return cart_products;
    }

    @Override
    public List<CartInfo> getSortedCart(String sort_type) throws InvalidSortingException {
        if(!sort_type.equals("asc") && !sort_type.equals("desc"))
            throw new InvalidSortingException("Invalid arrangement");
        String url="https://fakestoreapi.com/carts?sort="+sort_type;
        RestTemplate rest=new RestTemplate();
        CartDetailsDto[] fake_prod_list=rest.getForObject(url, CartDetailsDto[].class);
        List<CartInfo> cart_products=new ArrayList<>();
        for(CartDetailsDto cart_prod : fake_prod_list) {
            cart_products.add(convertToCustomCart(cart_prod));
        }
        return cart_products;
    }

    private CartInfo convertToCustomCart(CartDetailsDto cart_prod) {
        CartInfo new_cart=new CartInfo();
        new_cart.setUser_id(cart_prod.getUserId());
        new_cart.setProduct_detalis(cart_prod.getProducts());
        new_cart.setId(cart_prod.getId());
        return new_cart;
    }
}
