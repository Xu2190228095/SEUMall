package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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

    // 根据cid查询用户信息
    @GetMapping("/get/{id}")
    public Customer getCustomerByCid(@PathVariable Integer id) {
        return customerService.getCustomerByCid(id);
    }

    // 更新用户信息
    @PostMapping("/update")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        boolean updated = customerService.updateCustomerInfo(customer);
        if (updated) {
            return ResponseEntity.ok("User info updated successfully");
        } else {
            return ResponseEntity.status(400).body("Failed to update user info");
        }
    }
}
