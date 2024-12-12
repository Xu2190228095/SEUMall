package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public int delete(Customer customer);
    public List<Customer> findAll(Customer customer);
    public int insert(Customer customer);
    public int update(Customer customer);
}
