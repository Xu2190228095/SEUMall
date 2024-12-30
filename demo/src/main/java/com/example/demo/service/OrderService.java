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

    // 根据用户 cid 查询所有订单
    List<Order> getOrdersByUserId(Integer cid, String order_id, String state, String createTime, Integer price);

    public void submitReview(String order_id, Integer score, String comment);

    public boolean updateOrderStatusToReceived(String order_id);
}
