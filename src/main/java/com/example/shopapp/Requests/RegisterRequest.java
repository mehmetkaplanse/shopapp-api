package com.example.shopapp.Requests;

import lombok.Data;

@Data
public class RegisterRequest {
    String username;
    String email;
    String password;
}
