package com.introduction.ProductServiceAug24.Services;

import com.introduction.ProductServiceAug24.DTO.CartDetailsDto;
import com.introduction.ProductServiceAug24.Models.CartInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FakeStoreCartServices implements CartServices{
    @Override
    public CartInfo cartProducts(int id) {
        String url="https://fakestoreapi.com/carts/"+id;
        RestTemplate rest=new RestTemplate();
        CartDetailsDto cart_prod=rest.getForObject(url,CartDetailsDto.class);
        return convertToCustomCart(cart_prod);
    }

    private CartInfo convertToCustomCart(CartDetailsDto cart_prod) {
        CartInfo new_cart=new CartInfo();
        new_cart.setUser_id(cart_prod.getUserId());
        new_cart.setProduct_detalis(cart_prod.getProducts());
        return new_cart;
    }
}
