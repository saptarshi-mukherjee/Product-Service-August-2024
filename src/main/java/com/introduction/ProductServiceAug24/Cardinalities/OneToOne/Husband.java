package com.introduction.ProductServiceAug24.Cardinalities.OneToOne;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "husbands")
@Data
public class Husband {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @OneToOne
    Wife wife; // Establishing One-to-one cardinality with wife_id as foreign key
}
