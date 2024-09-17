package com.introduction.ProductServiceAug24.JoinedTable;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "JT_learners")
@PrimaryKeyJoinColumn(name = "user_id")
public class Learners extends Users{
    private String college;
    private String company;
}
