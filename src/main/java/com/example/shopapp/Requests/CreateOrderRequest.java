package com.example.shopapp.Requests;

import lombok.Data;

@Data
public class CreateOrderRequest {
    Long user_id;
    String name;
    Double price;
    int quantity;
}
