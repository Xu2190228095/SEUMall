package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll(Product product);
    public int insert(Product product);
    public int update(Product product);
    public int delete(Product product);
}
