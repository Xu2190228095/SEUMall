package com.example.demo.entity;

import java.io.Serializable;

public class Image implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String originUrl;
    private String remoteUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }
}