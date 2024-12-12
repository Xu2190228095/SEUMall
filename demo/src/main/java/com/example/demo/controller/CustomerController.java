package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/customer")
@CrossOrigin(origins="*")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @GetMapping("list")
    public Object queryList(Customer customer) {
        return customerService.findAll(customer);
    }
}
