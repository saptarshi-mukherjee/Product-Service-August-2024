package com.introduction.ProductServiceAug24.MappedSuperClass;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="msc_TAs")
public class TA extends Users{
    private long questions_solved;
    private String college;
}
