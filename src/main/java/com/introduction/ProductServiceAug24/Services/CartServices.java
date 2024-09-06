package com.introduction.ProductServiceAug24.Services;

import com.introduction.ProductServiceAug24.DTO.CartDetailsDto;
import com.introduction.ProductServiceAug24.Models.CartInfo;

public interface CartServices {
    public CartInfo cartProducts(int id);
}
