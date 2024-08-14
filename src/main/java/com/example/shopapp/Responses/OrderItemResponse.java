package com.example.shopapp.Responses;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemResponse {
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
