package com.example.demo.service.impl;

import com.example.demo.dao.DeptDao;
import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Scope("prototype") //多例
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao deptDao;

    @Override
    public List<Dept> findAll(Dept dept) {
        return this.deptDao.findAll(dept);
    }

    @Override
    public int insert(Dept dept) {
        return this.deptDao.insert(dept);
    }

    @Override
    public int update(Dept dept) {
        return this.deptDao.update(dept);
    }

    @Override
    public int delete(Dept dept) {
        return this.deptDao.delete(dept);
    }
}
