package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Order {
    private Integer id;
    private String order_id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8”")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create_time;
    private String state;
    private Integer number;
    private Integer score;
    private Integer uid;//商家id
    private Integer cid;//顾客id
    private String username;
    private Integer pid;
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cid=" + cid +
                ", id=" + id +
                ", order_id='" + order_id + '\'' +
                ", create_time=" + create_time +
                ", state='" + state + '\'' +
                ", number=" + number +
                ", score=" + score +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", pid=" + pid +
                ", price=" + price +
                '}';
    }
}
