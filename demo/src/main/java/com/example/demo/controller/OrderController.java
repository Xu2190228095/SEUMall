package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.CustomerService;
import com.example.demo.service.FileUploadService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.ProductServiceImpl;
import jakarta.annotation.Resource;
import org.csource.common.MyException;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

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
    private ProductServiceImpl productService;

    @Resource
    private UserService userService;

    @Resource
    private FileUploadService fileUploadService;

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
    public Map<String, Object> getOrdersByUserId(
            @RequestParam("cid") Integer cid,
            @RequestParam(value = "order_id", required = false) String order_id,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "create_time", required = false) String createTime,
            @RequestParam(value = "price", required = false) Integer price) throws MyException, IOException {

        Map<String, Object> map = new HashMap<>();
        List<Order> orders =orderService.getOrdersByUserId(cid, order_id, state, createTime, price);
//        List<byte[]> pictures = new ArrayList<>();
//        for (Order order:orders){
//            Product product = productService.findByProductid(order.getPid());
//            String remoteUrl = this.productService.findRemoteUrl(product.getImg());
//            pictures.add(fileUploadService.downLoadFile(remoteUrl));
//        }
        map.put("orders",orders);
        //map.put("pictures",pictures);
        return map;
    }

    // 使用 @RequestParam 获取 URL 查询参数
    @PostMapping("/submitReview")
    public ResponseEntity<String> submitReview(@RequestParam("order_id") String order_id,
                                               @RequestParam(value = "score") Integer score,
                                               @RequestParam(value = "comment") String comment) {
        try {
            System.out.println("Received order_id: " + order_id);  // 调试
            System.out.println("Received score: " + score);  // 调试
            System.out.println("Received comment: " + comment);  // 调试
            orderService.submitReview(order_id, score, comment);
            return ResponseEntity.ok("Review submitted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting review");
        }
    }

    // 确认收货接口
    @PutMapping("/confirm-receipt/{orderId}")
    public ResponseEntity<String> confirmReceipt(@PathVariable("orderId") String order_id) {
        try {
            boolean updated = orderService.updateOrderStatusToReceived(order_id);
            if (updated) {
                return ResponseEntity.ok("订单状态已更新为已收货");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("未找到该订单或订单状态不符合要求");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务器错误: " + e.getMessage());
        }
    }
}
