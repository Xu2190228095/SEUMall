package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Scope("prototype")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Override
    public int delete(Order order) {
        return orderDao.delete(order);
    }

    @Override
    public List<Order> findAll(Order order) {
        return orderDao.findAll(order);
    }

    @Override
    public int insert(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public int update(Order order) {
        return orderDao.update(order);
    }
}
