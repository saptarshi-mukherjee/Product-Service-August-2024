package com.introduction.ProductServiceAug24.Services;


import com.introduction.ProductServiceAug24.DTO.NameAndBatchDto;
import com.introduction.ProductServiceAug24.Models.Batch;
import com.introduction.ProductServiceAug24.Models.Learner;
import com.introduction.ProductServiceAug24.Repositories.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface EdTechService {
    public Batch createBatch(String name);
    public Batch getBatchById(long id);
    public Learner createLearner(String name, long batch_id);
    public Learner getLearnerById(long id);
    public NameAndBatchDto getNameAndBatch(long id);
}
