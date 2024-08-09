package com.example.shopapp.Requests;

import lombok.Data;

@Data
public class UpdateOrderRequest {
    Long user_id;
    String name;
    Double price;
    int quantity;
}
