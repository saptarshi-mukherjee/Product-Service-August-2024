package com.introduction.ProductServiceAug24.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;


@Data
@Entity(name="JT_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {
    @Id
    long id;
    String name, email, password;
}
