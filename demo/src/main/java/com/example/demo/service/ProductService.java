package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.entity.Product;

import java.util.List;

/**
 * @author 18536
 */
public interface ProductService {
    public List<Product> findAll(Product product);
    public int insert(Product product);
    public int update(Product product);
    public int delete(Product product);
    public Product findByProductname(String productname);
    public Product findByProductid(Integer productid);

    public List<Product> fetchList(int pageNum, int pageSize, Product product);
    public Object searchTotal(Product product);
}
