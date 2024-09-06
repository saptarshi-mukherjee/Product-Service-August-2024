package com.introduction.ProductServiceAug24.Controllers;


import com.introduction.ProductServiceAug24.DTO.CartDetailsDto;
import com.introduction.ProductServiceAug24.Models.CartInfo;
import com.introduction.ProductServiceAug24.Services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    CartServices cart;

    @GetMapping("/{id}")
    public ResponseEntity<CartInfo> getCartDetails(@PathVariable("id") int id) {
        CartInfo cart_prod=cart.cartProducts(id);
        return new ResponseEntity<CartInfo>(cart_prod, HttpStatusCode.valueOf(200));
    }
}
