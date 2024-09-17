package com.introduction.ProductServiceAug24.SingleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("mentors")
public class Mentors extends Users{
    private String current_company;
    private String college;
}
