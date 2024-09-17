package com.introduction.ProductServiceAug24.SingleTable;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name="app_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class Users {
    @Id
    long id;
    String name, email, password;
}
