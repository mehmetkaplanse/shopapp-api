package com.example.shopapp.Responses;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private String user;
    private String name;
    private double price;
    private int quantity;
    private Date createdDate;
}
