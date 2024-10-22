package com.example.demo.service;

import com.example.demo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface DeptService {
    public List<Dept> findAll(Dept dept);
    public int insert(Dept dept);
    public int update(Dept dept);
    public int delete(Dept dept);
}
