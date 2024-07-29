package com.example.shopapp.Requests;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String name;
    private Double price;
    private String explanation;
    private Long category_id;
}
