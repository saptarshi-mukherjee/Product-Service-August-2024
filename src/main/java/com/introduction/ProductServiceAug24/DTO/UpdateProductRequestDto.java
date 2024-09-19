package com.introduction.ProductServiceAug24.DTO;


import lombok.Data;

@Data
public class UpdateProductRequestDto {
    long id;
    String name, category, description;
}
