package com.example.demo.service.impl;

import com.example.demo.dao.CustomerDao;
import com.example.demo.entity.Customer;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("customerDetailsServiceImpl")
public class CustomerDetailsServiceImpl implements UserDetailsService {
    @Resource
    private CustomerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过UserDao根据用户名查询用户信息
        Customer customer = customerDao.findByUsername(username);
        // 如果用户不存在，抛出异常
        if (customer == null) {
            throw new UsernameNotFoundException("Customer not found");
        }
        // 返回UserDetails对象，包含用户名、密码和权限列表（此处简化为返回空列表）
        return new org.springframework.security.core.userdetails.User(customer.getUsername(),
                customer.getPassword(), new ArrayList<>());
    }
}
