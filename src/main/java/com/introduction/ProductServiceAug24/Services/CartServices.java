package com.introduction.ProductServiceAug24.Services;

import com.introduction.ProductServiceAug24.DTO.CartDetailsDto;
import com.introduction.ProductServiceAug24.Exceptions.InvalidSortingException;
import com.introduction.ProductServiceAug24.Exceptions.ProductLimitOutOfBoundsException;
import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import com.introduction.ProductServiceAug24.Models.Cart;
import com.introduction.ProductServiceAug24.Models.CartInfo;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface CartServices {
    public CartInfo cartProducts(int id) throws ProductNotFoundExceptions;
    public List<CartInfo> getLimitedCartDetails(Integer limit) throws ProductLimitOutOfBoundsException;
    public List<CartInfo> getSortedCart(String sort_type) throws InvalidSortingException;
}
