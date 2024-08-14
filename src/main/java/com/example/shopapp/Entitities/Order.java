package com.example.shopapp.Entitities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private double price;
    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;
}
