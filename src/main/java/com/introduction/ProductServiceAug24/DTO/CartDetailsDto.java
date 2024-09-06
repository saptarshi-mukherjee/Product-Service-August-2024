package com.introduction.ProductServiceAug24.DTO;

import com.introduction.ProductServiceAug24.Models.ProductDescriptionInCart;

import java.util.List;

public class CartDetailsDto {
    int id, userId;
    String date;
    List<ProductDescriptionInCart> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ProductDescriptionInCart> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDescriptionInCart> products) {
        this.products = products;
    }
}
