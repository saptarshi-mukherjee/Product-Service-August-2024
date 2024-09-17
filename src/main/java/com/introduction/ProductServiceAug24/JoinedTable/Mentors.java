package com.introduction.ProductServiceAug24.JoinedTable;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name="JT_mentors")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentors extends Users{
    private String current_company;
    private String college;
}
