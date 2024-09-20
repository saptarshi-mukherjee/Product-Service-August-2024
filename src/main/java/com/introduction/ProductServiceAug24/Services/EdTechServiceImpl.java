package com.introduction.ProductServiceAug24.Services;

import com.introduction.ProductServiceAug24.DTO.NameAndBatchDto;
import com.introduction.ProductServiceAug24.Models.Batch;
import com.introduction.ProductServiceAug24.Models.Learner;
import com.introduction.ProductServiceAug24.Repositories.BatchRepository;
import com.introduction.ProductServiceAug24.Repositories.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EdTechServiceImpl implements EdTechService{

    @Autowired
    BatchRepository batch_repo;
    @Autowired
    LearnerRepository learner_repo;

    @Override
    public Batch createBatch(String name) {
        Batch batch=new Batch();
        batch.setBatch_name(name);
        batch_repo.save(batch);
        return batch;
    }

    @Override
    public Batch getBatchById(long id) {
        return batch_repo.fetchBatchById(id);
    }

    @Override
    public Learner createLearner(String name, long batch_id) {
        Learner learner=new Learner();
        Batch batch=getBatchById(batch_id);
        learner.setName(name);
        learner.setBatch(batch);
        learner_repo.save(learner);
        return learner;
    }

    @Override
    public Learner getLearnerById(long id) {
        return learner_repo.fetchLearnerById(id);
    }

    @Override
    public NameAndBatchDto getNameAndBatch(long id) {
        List<Object[]> result=learner_repo.fetchNameAndBatch(id);
        NameAndBatchDto result_set=new NameAndBatchDto();
        result_set.setLearner_name(result.get(0)[0].toString());
        result_set.setBatch_name(result.get(0)[1].toString());
        return result_set;
    }

}
