package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> findAll(User user) {
        return userDao.findAll(user);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> fetchList(int page, int size, User user) {
        Map<String, Object> map = new HashMap<>();
        int start = (page - 1) * size;
        map.put("start", start);
        map.put("size", size);
        map.put("userInfo", user);
        return userDao.fetchList(map);
    }

    @Override
    public Object searchTotal(User user) {
        return userDao.searchTotal(user);
    }
}
