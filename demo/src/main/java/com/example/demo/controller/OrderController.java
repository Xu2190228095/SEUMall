package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@Scope("prototype")
@RequestMapping("/order")
@CrossOrigin(origins="*")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private CustomerService customerService;

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public Object queryList(com.example.demo.entity.Order order) {
        return orderService.findAll(order);
    }

    @GetMapping("/fetchList")
    public Map<String, Object> fetchList(int pageNum, int pageSize, String keyword_username,Order order) {
        System.out.println("order:"+order);
        SecurityContext securityContext = SecurityContextHolder.getContext();//获取用户上下文对象
        String username = securityContext.getAuthentication().getName();//获取用户名
//        String character = null;//获取用户角色
//        Collection<? extends GrantedAuthority> authorities = securityContext.getAuthentication().getAuthorities();
//        if (authorities != null && !authorities.isEmpty()) {
//            // 获取第一个 GrantedAuthority
//            GrantedAuthority authority = authorities.iterator().next();
//            character = authority.getAuthority(); // 获取该权限的值
//        }
        User user = userService.findByUsername(username);
        order.setUid(user.getUid());
        Map<String, Object> map = new HashMap<>();
        map.put("list",this.orderService.fetchList(pageNum, pageSize, keyword_username,order));
        map.put("total",this.orderService.searchTotal(keyword_username,order));
        return map;
    }

    @PostMapping("/deleteOrder")
    public Object delete(@RequestBody Order order) {
        return orderService.delete(order);
    }

    @PostMapping("/updateOrderStatus")
    public Object update(@RequestBody Order order) {
        order.setState("已发货");
        return orderService.update(order);
    }
}
