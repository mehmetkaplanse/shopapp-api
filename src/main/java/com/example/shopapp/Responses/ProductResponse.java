package com.example.shopapp.Responses;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private String explanation;
    private String image;
    private Long category_id;

}
