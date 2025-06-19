package com.example.demo_crud_api.repositories;

import com.example.demo_crud_api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
