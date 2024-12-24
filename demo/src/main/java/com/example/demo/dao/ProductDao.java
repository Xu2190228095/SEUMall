package com.example.demo.dao;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductDao {
    public List<Product> findAll(Product product);
    public int insert(Product product);
    public int update(Product product);
    public int delete(Product product);
    public Product findByProductname(String productname);
    public Product findByProductid(Integer productid);
    // 根据商品ID查询商品
    public Product fetchProduct(Integer productid);  // 根据productid查询商品

    List<Product> findByProductClass(String productClass);

    String findRemoteUrl(String img);

    public List<Product> fetchList(Map <String, Object> map);
    Object searchTotal(Product product);
}

