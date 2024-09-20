package com.introduction.ProductServiceAug24.Repositories;


import com.introduction.ProductServiceAug24.DTO.NameAndBatchDto;
import com.introduction.ProductServiceAug24.Models.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnerRepository extends JpaRepository<Learner,Long> {

    @Query(value = "select * from learners where id=:id", nativeQuery = true)
    public Learner fetchLearnerById(long id);

    @Query(value = "select l.name, b.batch_name\n" +
            "from learners as l\n" +
            "join batches as b\n" +
            "on l.batch_id=b.id\n" +
            "where l.id=:learner_id", nativeQuery = true)
    public List<Object[]> fetchNameAndBatch(long learner_id);
}
