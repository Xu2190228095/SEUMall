package com.example.demo.service.impl;

import com.example.demo.dao.CustomerDao;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@Scope("prototype")
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;

    @Override
    public int delete(Customer customer) {
        return customerDao.delete(customer);
    }

    @Override
    public List<Customer> findAll(Customer customer) {
        return customerDao.findAll(customer);
    }

    @Override
    public int insert(Customer customer) {
        return customerDao.insert(customer);
    }

    @Override
    public int update(Customer customer) {
        return customerDao.update(customer);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerDao.findByUsername(username);
    }

    @Override
    public Customer getCustomerByCid(Integer id) {
        return customerDao.getCustomerByCid(id);
    }

    @Override
    public boolean updateCustomerInfo(Customer customer) {
        int result = customerDao.updateCustomerInfo(customer);
        return result > 0; // 如果更新影响的行数大于 0，表示更新成功
    }
}
