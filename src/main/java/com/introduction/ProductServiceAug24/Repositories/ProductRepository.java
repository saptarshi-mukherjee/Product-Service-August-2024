package com.introduction.ProductServiceAug24.Repositories;

import com.introduction.ProductServiceAug24.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
