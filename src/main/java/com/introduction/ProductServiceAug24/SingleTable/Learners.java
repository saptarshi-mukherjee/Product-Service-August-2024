package com.introduction.ProductServiceAug24.SingleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("learners")
public class Learners extends Users{
    private String college;
    private String company;
}
