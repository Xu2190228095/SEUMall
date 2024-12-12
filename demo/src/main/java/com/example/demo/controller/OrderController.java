package com.example.demo.controller;

import com.example.demo.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/order")
@CrossOrigin(origins="*")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/list")
    public Object queryList(com.example.demo.entity.Order order) {
        return orderService.findAll(order);
    }
}
