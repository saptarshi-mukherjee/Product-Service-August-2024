package com.introduction.ProductServiceAug24.MappedSuperClass;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="msc_learners")
public class Learners extends Users{
    private String college;
    private String company;
}
