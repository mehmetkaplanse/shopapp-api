package com.example.shopapp.Requests;

import lombok.Data;
import java.util.List;

@Data
public class CreateOrderRequest {
    private Long user_id;
    private String name;
    private double price;
    private int quantity;
}

