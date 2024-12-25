package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Scope("prototype")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

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

    @Override
    public List<Order> fetchList(int page, int size, String keyword_customerName,Order order) {
        Map<String, Object> map = new HashMap<>();
        int start = (page - 1) * size;
        map.put("start", start);
        map.put("size", size);
        map.put("customerName", keyword_customerName);
        map.put("orderInfo", order);
        return orderDao.fetchList(map);
    }

    @Override
    public Object searchTotal(String keyword_customerName,Order order) {
        Map<String, Object> map = new HashMap<>();
        map.put("customerName", keyword_customerName);
        map.put("orderInfo", order);
        return orderDao.searchTotal(map);
    }

    // 根据用户 cid 查询所有订单
    @Override
    public List<Order> getOrdersByUserId(Integer cid, String order_id, String state, String createTime, Integer price) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("cid", cid);
        paramMap.put("order_id", order_id);
        paramMap.put("state", state);
        paramMap.put("createTime", createTime);
        paramMap.put("price", price);
        return orderDao.findOrdersByCid(paramMap);
    }
}
