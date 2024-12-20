package com.example.demo.controller;

import com.example.demo.entity.Dept;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @PostMapping("/delete")
    public Object delete(@RequestBody User user) {
        System.out.println("user:"+user);
        return this.userService.delete(user);
    }

    @PostMapping("/update")
    public Object update(@RequestBody User user) {
        System.out.println("user:"+user);
        return this.userService.update(user);
    }

    @GetMapping("/findByUsername")
    public Object findByUsername(String username) {
        return this.userService.findByUsername(username);
    }

    @GetMapping("/fetchList")
    public Map<String, Object> fetchList(int pageNum, int pageSize, User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("list",this.userService.fetchList(pageNum, pageSize, user));
        map.put("total",this.userService.searchTotal(user));
    	return map;
    }

    @PostMapping("/insert")
    public Object insert(@RequestBody User user) {
        user.setCreateTime(new Date(System.currentTimeMillis()));
        return this.userService.insert(user);
    }

}
