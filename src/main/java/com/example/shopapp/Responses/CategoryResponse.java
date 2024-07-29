package com.example.shopapp.Responses;

import com.example.shopapp.Entitities.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {
    private Long id;
    private String name;
    private List<Category> products;
}
