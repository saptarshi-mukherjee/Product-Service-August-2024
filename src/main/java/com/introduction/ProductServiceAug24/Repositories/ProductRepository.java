package com.introduction.ProductServiceAug24.Repositories;

import com.introduction.ProductServiceAug24.DTO.NameAndIdResponseDto;
import com.introduction.ProductServiceAug24.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select * from products_db\n" +
            "where id= :id", nativeQuery = true)
    public Optional<Product> fetchProductById(@Param("id") Long id);

    @Query(value = "select * from products_db", nativeQuery = true)
    public List<Product> fetchAllProducts();

    @Query(value = "select distinct category\n" +
            "from products_db", nativeQuery = true)
    public List<String> fetchAllCategories();

    @Query(value = "select id, name " +
            "from products_db\n" +
            "where trim(lower(name)) like trim(concat('%',:name,'%'))", nativeQuery = true)
    public List<Object[]> fetchNameAndId(@Param("name") String name);
}
