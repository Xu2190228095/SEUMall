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
import java.util.List;
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

    // 根据 cid 获取所有订单
    @GetMapping("/customerOrder")
    public List<Order> getOrdersByUserId(
            @RequestParam("cid") Integer cid,
            @RequestParam(value = "order_id", required = false) String order_id,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "create_time", required = false) String createTime,
            @RequestParam(value = "price", required = false) Integer price){
        return orderService.getOrdersByUserId(cid, order_id, state, createTime, price);
    }
}
