package com.introduction.ProductServiceAug24.Repositories;

import com.introduction.ProductServiceAug24.DTO.UserAndProductDto;
import com.introduction.ProductServiceAug24.Models.Cart;
import com.introduction.ProductServiceAug24.Projections.NameAndProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    @Query(value = "select * from carts where id = :id", nativeQuery = true)
    public Cart fetchCartById(long id);

    @Query(value = "select carts.user_name as user, prod.name as name\n" +
            "from carts\n" +
            "join carts_products as cp\n" +
            "on carts.id=cp.carts_id\n" +
            "join products_db as prod\n" +
            "on prod.id=cp.products_id\n" +
            "where carts.id=:cart_id", nativeQuery = true)
    public NameAndProductInfo fetchUserAndProduct(long cart_id);
}
