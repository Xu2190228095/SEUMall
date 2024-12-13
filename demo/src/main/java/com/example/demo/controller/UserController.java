package com.example.demo.controller;

import com.example.demo.entity.Dept;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/insert")
    public Object insert(User user) {
        System.out.println("user:"+user);
        return this.userService.insert(user);
    }

    @GetMapping("/delete")
    public Object delete(User user) {
        System.out.println("user:"+user);
        return this.userService.delete(user);
    }

    @GetMapping("/update")
    public Object update(User user) {
        System.out.println("user:"+user);
        return this.userService.update(user);
    }

    @GetMapping("/findByUsername")
    public Object findByUsername(String username) {
        return this.userService.findByUsername(username);
    }
}
