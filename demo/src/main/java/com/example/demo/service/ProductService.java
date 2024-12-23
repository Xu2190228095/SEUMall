package com.example.demo.service;

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
    // 根据商品ID查询商品
    public Product fetchProduct(Integer productid);  // 新增接口方法

    List<Product> findByProductClass(String productClass);

    String findRemoteUrl(String img);
}
