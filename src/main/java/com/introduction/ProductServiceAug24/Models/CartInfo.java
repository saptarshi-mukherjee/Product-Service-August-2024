package com.introduction.ProductServiceAug24.Models;

import java.util.List;

public class CartInfo {
    int user_id, id;
    List<ProductDescriptionInCart> product_detalis;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<ProductDescriptionInCart> getProduct_detalis() {
        return product_detalis;
    }

    public void setProduct_detalis(List<ProductDescriptionInCart> product_detalis) {
        this.product_detalis = product_detalis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
