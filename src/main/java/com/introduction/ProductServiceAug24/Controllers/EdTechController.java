package com.introduction.ProductServiceAug24.Controllers;


import com.introduction.ProductServiceAug24.DTO.BatchDto;
import com.introduction.ProductServiceAug24.DTO.LearnerDto;
import com.introduction.ProductServiceAug24.DTO.NameAndBatchDto;
import com.introduction.ProductServiceAug24.Models.Batch;
import com.introduction.ProductServiceAug24.Models.Learner;
import com.introduction.ProductServiceAug24.Services.EdTechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EdTechController {

    @Autowired
    EdTechService ed_service;

    @PostMapping("/ed/create/batch")
    public Batch createNewBatch(@RequestBody BatchDto bdto) {
        return ed_service.createBatch(bdto.getName());
    }

    @PostMapping("/ed/create/learner")
    public Learner createNewLearner(@RequestBody LearnerDto ldto) {
        return ed_service.createLearner(ldto.getName(), ldto.getBatch_id());
    }

    @GetMapping("/ed/get/batch/{id}")
    public Batch getDBBatchById(@PathVariable("id") long id) {
        return ed_service.getBatchById(id);
    }

    @GetMapping("/ed/get/learner/{id}")
    public Learner getDBLearnerById(@PathVariable("id") long id) {
        return ed_service.getLearnerById(id);
    }

    @GetMapping("/ed/get/name_and_batch/{id}")
    public NameAndBatchDto getDBNameAndBatch(@PathVariable("id") long id) {
        return ed_service.getNameAndBatch(id);
    }
}
