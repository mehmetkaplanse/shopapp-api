package com.example.shopapp.Requests;

import lombok.Data;

@Data
public class UpdateProductRequest {
    private String name;
    private Double price;
    private String explanation;
    private String image;
    private Long category_id;
}
