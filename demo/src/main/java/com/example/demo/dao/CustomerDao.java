package com.example.demo.dao;

import com.example.demo.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerDao {
    public int delete(Customer customer);
    public List<Customer> findAll(Customer customer);
    public int insert(Customer customer);
    public int update(Customer customer);
    public Customer findByUsername(String username);

    // 根据cid查询用户信息
    public Customer getCustomerByCid(Integer id);

    // 获取用户信息

    // 更新用户信息
    public int updateCustomerInfo(Customer customer);
}
