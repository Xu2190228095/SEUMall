package com.example.demo.service.impl;

import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Comments;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Scope("prototype")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @Resource
    private CommentsDao commentsDao;

    @Override
    public int delete(Order order) {
        return orderDao.delete(order);
    }

    @Override
    public List<Order> findAll(Order order) {
        return orderDao.findAll(order);
    }

    @Override
    public int insert(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public int update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public List<Order> fetchList(int page, int size, String keyword_customerName,Order order) {
        Map<String, Object> map = new HashMap<>();
        int start = (page - 1) * size;
        map.put("start", start);
        map.put("size", size);
        map.put("customerName", keyword_customerName);
        map.put("orderInfo", order);
        return orderDao.fetchList(map);
    }

    @Override
    public Object searchTotal(String keyword_customerName,Order order) {
        Map<String, Object> map = new HashMap<>();
        map.put("customerName", keyword_customerName);
        map.put("orderInfo", order);
        return orderDao.searchTotal(map);
    }

    // 根据用户 cid 查询所有订单
    @Override
    public List<Order> getOrdersByUserId(Integer cid, String order_id, String state, String createTime, Integer price) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("cid", cid);
        paramMap.put("order_id", order_id);
        paramMap.put("state", state);
        paramMap.put("createTime", createTime);
        paramMap.put("price", price);
        return orderDao.findOrdersByCid(paramMap);
    }

    /**
     * 提交评论和更新订单状态
     */
    @Override
    public void submitReview(String order_id, Integer score, String comment) {
        // 1. 查询订单信息
        Order order = orderDao.findById(order_id);
        System.out.println(order_id);  // 打印接收到的请求体
        if (order == null) {
            throw new IllegalArgumentException("Order not found with ID: " + order_id);
        }

        // 2. 在 Comments 表中插入新的评论记录
        Comments newComment = new Comments();
        newComment.setPid(order.getPid());  // 订单中的商品ID
        newComment.setCid(order.getCid());  // 订单中的顾客ID
        newComment.setScore(score);         // 传入的评分
        newComment.setComment(comment);     // 传入的评论
        System.out.println(newComment);
        commentsDao.save(newComment);       // 使用 MyBatis 插入评论

        // 3. 更新 Order 的状态为 "已完成"
        order.setState("已完成");

        orderDao.updateOrderState(order);   // 使用 MyBatis 更新订单状态
    }

    /**
     * 更新订单状态为 "已收货"
     * @param order_id 订单ID
     * @return 是否更新成功
     */
    public boolean updateOrderStatusToReceived(String order_id) {
        // 查询订单
        Order order = orderDao.findById(order_id);

        if (order != null && "已发货".equals(order.getState())) {
            // 修改订单状态
            order.setState("已收货");
            orderDao.updateOrderState(order);   // 使用 MyBatis 更新订单状态
            return true;
        }

        return false;
    }
}
