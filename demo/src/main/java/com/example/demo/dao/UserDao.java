package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    public List<User> findAll(User user);
    public int insert(User user);
    public int update(User user);
    public int delete(User user);
    public User findByUsername(String username);

    public List<User> fetchList(Map<String, Object> map);

    Object searchTotal(User user);
}
