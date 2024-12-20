package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll(User user);
    public int insert(User user);
    public int update(User user);
    public int delete(User user);
    public User findByUsername(String username);

    public List<User> fetchList(int page, int size, User user);

    Object searchTotal(User user);
}
