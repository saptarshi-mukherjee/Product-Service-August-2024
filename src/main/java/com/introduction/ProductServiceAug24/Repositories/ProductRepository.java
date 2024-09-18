package com.introduction.ProductServiceAug24.Repositories;

import com.introduction.ProductServiceAug24.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select * from products_db\n" +
            "where id= :id", nativeQuery = true)
    public Product fetchProductById(@Param("id") Long id);

    @Query(value = "select * from products_db", nativeQuery = true)
    public List<Product> fetchAllProducts();
}
