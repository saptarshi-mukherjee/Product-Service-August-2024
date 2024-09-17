package com.introduction.ProductServiceAug24.SingleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("TAs")
public class TAs extends Users{
    private long questions_solved;
    private String college;
}
