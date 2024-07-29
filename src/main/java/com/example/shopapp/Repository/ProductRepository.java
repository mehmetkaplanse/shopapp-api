package com.example.shopapp.Repository;

import com.example.shopapp.Entitities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
