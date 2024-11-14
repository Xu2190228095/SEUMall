package com.example.demo.service.impl;

import java.util.Date;

import com.example.demo.service.RedisService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
@Service
@Scope("prototype")
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate redisTemplate;
    /**
     * 对hash类型的数据操作
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public HashOperations<String, String, Object> hashOperations() {
        return redisTemplate.opsForHash();
    }
    /**
     * 对redis字符串类型数据操作
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public ValueOperations<String, Object> valueOperations() {
        return redisTemplate.opsForValue();
    }
    /**
     * 对链表类型的数据操作
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public ListOperations<String, Object> listOperations() {
        return redisTemplate.opsForList();
    }
    /**
     * 对无序集合类型的数据操作
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public SetOperations<String, Object> setOperations() {
        return redisTemplate.opsForSet();
    }
    /**
     * 对有序集合类型的数据操作
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public ZSetOperations<String, Object> zSetOperations() {
        return redisTemplate.opsForZSet();
    }
    /**
     * 指定某个key可以存活到什么时候
     */
    @SuppressWarnings("unchecked")
    @Override
    public void expireKeyAt(String key, Date date) {
// TODO Auto-generated method stub
        redisTemplate.expireAt(key, date);
    }
    /**
     * 指定某个key永久存活
     */
    @SuppressWarnings("unchecked")
    @Override
    public void persistKey(String key) {
// TODO Auto-generated method stub
        redisTemplate.persist(key);
    }
    /**
     * 删除某个key
     */
    @SuppressWarnings("unchecked")
    @Override
    public void deleteKey(String key) {
// TODO Auto-generated method stub
        redisTemplate.delete(key);
    }
    /**
     * 判断某个key是否存在
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean existsKey(String key) {
// TODO Auto-generated method stub
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }
    /**
     * 改名
     */
    @SuppressWarnings("unchecked")
    @Override
    public void renameKey(String oldKey, String newKey) {
// TODO Auto-generated method stub
        redisTemplate.rename(oldKey, newKey);
    }
    /**
     * 当key存在才改名
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean renameKeyNotExist(String oldKey, String newKey) {
// TODO Auto-generated method stub
        return Boolean.TRUE.equals(redisTemplate.renameIfAbsent(oldKey, newKey));
    }
}