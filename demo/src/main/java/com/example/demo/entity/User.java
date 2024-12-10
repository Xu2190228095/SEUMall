package com.example.demo.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String password;
    private String character;
    private String lastLoginTime;
    private boolean isActive;

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

