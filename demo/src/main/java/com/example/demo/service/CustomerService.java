package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    public int delete(Customer customer);
    public List<Customer> findAll(Customer customer);
    public int insert(Customer customer);
    public int update(Customer customer);

    public Customer findByUsername(String username);

    // 获取用户信息
    public Customer getCustomerByCid(Integer id);

    // 更新用户信息
    public boolean updateCustomerInfo(Customer customer);
}
