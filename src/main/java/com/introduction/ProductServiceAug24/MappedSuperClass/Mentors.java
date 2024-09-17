package com.introduction.ProductServiceAug24.MappedSuperClass;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="msc_mentors")
public class Mentors extends Users{
    private String current_company;
    private String college;
}
