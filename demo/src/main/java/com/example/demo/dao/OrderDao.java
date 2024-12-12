package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    public int delete(Order order);
    public int insert(Order order);
    public int update(Order order);
    public List<Order> findAll(Order order);
}
