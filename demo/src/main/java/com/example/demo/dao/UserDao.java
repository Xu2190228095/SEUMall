package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public List<User> findAll(User user);
    public int insert(User user);
    public int update(User user);
    public int delete(User user);
    public User findByUsername(String username);
}
