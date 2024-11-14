package com.example.demo.service;

import java.util.Date;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

public interface RedisService {
    public HashOperations<String, String, Object> hashOperations();
    public ValueOperations<String, Object> valueOperations();
    public ListOperations<String, Object> listOperations();
    public SetOperations<String, Object> setOperations();
    public ZSetOperations<String, Object> zSetOperations();
    public void expireKeyAt(String key, Date date);
    public void persistKey(String key);
    public void deleteKey(String key);
    public boolean existsKey(String key);
    public void renameKey(String oldKey, String newKey);
    public boolean renameKeyNotExist(String oldKey, String newKey);
}
