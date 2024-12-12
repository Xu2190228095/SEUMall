package com.example.demo.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pid;
    private String productname;
    private String desc;
    private Integer price;
    private Integer number;
    private String img;
    private Integer pclass;

    public Integer getId() {
        return pid;
    }

    public void setId(Integer pid) {
        this.pid = pid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPclass() {
        return pclass;
    }

    public void setPclass(Integer pclass) {
        this.pclass = pclass;
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
}

