package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.RedisService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class BasicController {

    @Resource
    private RedisService service;

    @PostMapping("/login")
    public Object login(User user){
        //使用redis来完成用于登入信息的保存
        service.valueOperations().set(user.getUsername(),user);
        return null;
    }

}
