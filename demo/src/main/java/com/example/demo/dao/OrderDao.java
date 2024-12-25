package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {
    public int delete(Order order);
    public int insert(Order order);
    public int update(Order order);
    public List<Order> findAll(Order order);

    public List<Order> fetchList(Map<String, Object> map);

    Object searchTotal(Map<String, Object> map);

    // 根据 cid 查询订单
    List<Order> findOrdersByCid(Map<String, Object> map);

}
