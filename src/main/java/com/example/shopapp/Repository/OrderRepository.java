package com.example.shopapp.Repository;

import com.example.shopapp.Entitities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
