package com.example.demo_crud_api.controllers;

import com.example.demo_crud_api.repositories.*;
import com.example.demo_crud_api.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository _productRepo;

    public ProductController(ProductRepository productRepository) {
        _productRepo = productRepository;
    }

    @GetMapping
    public List<Product> getAll(){
        return _productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return _productRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return _productRepo.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product newProduct){
        newProduct.setId(id);
        return _productRepo.save(newProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        _productRepo.deleteById(id);
    }
}
