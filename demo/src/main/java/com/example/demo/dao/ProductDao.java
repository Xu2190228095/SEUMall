package com.example.demo.dao;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    public List<Product> findAll(Product product);
    public int insert(Product product);
    public int update(Product product);
    public int delete(Product product);
    public Product findByProductname(String productname);
    public Product findByProductid(Integer productid);
}

