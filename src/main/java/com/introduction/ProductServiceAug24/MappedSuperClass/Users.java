package com.introduction.ProductServiceAug24.MappedSuperClass;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class Users {
    @Id
    long id;
    String name, email, password;
}
