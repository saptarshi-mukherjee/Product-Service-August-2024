package com.introduction.ProductServiceAug24.JoinedTable;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "JT_TAs")
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends Users{
    private long questions_solved;
    private String college;
}
