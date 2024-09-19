package com.introduction.ProductServiceAug24.Cardinalities.ManyToOne;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name="learners")
@Data
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @ManyToOne
    Batch batch;
}
