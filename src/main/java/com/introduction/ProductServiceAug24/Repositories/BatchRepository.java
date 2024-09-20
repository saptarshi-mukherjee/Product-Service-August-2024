package com.introduction.ProductServiceAug24.Repositories;


import com.introduction.ProductServiceAug24.Models.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch,Long> {

    @Query(value = "select * from batches where id=:batch_id", nativeQuery = true)
    public Batch fetchBatchById(long batch_id);
}
