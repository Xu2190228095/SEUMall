package com.example.demo.service;

import com.example.demo.entity.Order;

import java.util.List;

public interface OrderService {
    public int delete(Order order);
    public List<Order> findAll(Order order);
    public int insert(Order order);
    public int update(Order order);

    public List<Order> fetchList(int pageNum, int pageSize, String keyword_customerName,Order order);

    public Object searchTotal(String keyword_customerName,Order order);
}
