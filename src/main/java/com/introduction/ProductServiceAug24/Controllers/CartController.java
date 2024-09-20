package com.introduction.ProductServiceAug24.Controllers;


import com.introduction.ProductServiceAug24.DTO.CartDetailsDto;
import com.introduction.ProductServiceAug24.DTO.CartDto;
import com.introduction.ProductServiceAug24.DTO.UserAndProductDto;
import com.introduction.ProductServiceAug24.Exceptions.InvalidSortingException;
import com.introduction.ProductServiceAug24.Exceptions.ProductLimitOutOfBoundsException;
import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import com.introduction.ProductServiceAug24.Models.Cart;
import com.introduction.ProductServiceAug24.Models.CartInfo;
import com.introduction.ProductServiceAug24.Services.CartServices;
import com.introduction.ProductServiceAug24.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    CartServices cart;
    @Autowired
    @Qualifier("custom DB service")
    ProductService prod;

    @GetMapping("/{id}")
    public ResponseEntity<CartInfo> getCartDetails(@PathVariable("id") int id) throws ProductNotFoundExceptions {
        CartInfo cart_prod=cart.cartProducts(id);
        return new ResponseEntity<CartInfo>(cart_prod, HttpStatusCode.valueOf(200));
    }

    @GetMapping("")
    public ResponseEntity<List<CartInfo>> getLimitedCartDetails(@RequestParam(value="limit", required = false) Integer limit,
                                                                @RequestParam(value = "sort", required=false) String sort_type)
                                                                throws InvalidSortingException, ProductLimitOutOfBoundsException {
        if(sort_type==null) {
            List<CartInfo> cart_list=cart.getLimitedCartDetails(limit);
            return new ResponseEntity<>(cart_list, HttpStatusCode.valueOf(200));
        }
        else {
            List<CartInfo> cart_list=cart.getSortedCart(sort_type);
            return new ResponseEntity<>(cart_list, HttpStatusCode.valueOf(200));
        }
    }

    @PostMapping("/create")
    public Cart getUserCarts(@RequestBody CartDto cart_dto) {
        return prod.createCart(cart_dto.getUser_name(), cart_dto.getProduct_id());
    }

    @GetMapping("/db/get/{id}")
    public Cart getCartFromDB(@PathVariable("id") long id) {
        return prod.getCartById(id);
    }

    @GetMapping("/db/get/user_product/{cart_id}")
    public UserAndProductDto getUserAndProductFromDB(@PathVariable("cart_id") long cart_id) {
        return prod.getUserAndProduct(cart_id);
    }
}
