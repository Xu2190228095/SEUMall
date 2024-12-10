package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/list")
    public Object queryList(User user) {
        return this.userService.findAll(user);
    }
}
