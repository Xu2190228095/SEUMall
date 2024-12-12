package com.example.demo.dao;

import com.example.demo.entity.Complaint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComplaintDao {
    public int delete(Complaint complaint);
    public int insert(Complaint complaint);
    public int update(Complaint complaint);
    public List<Complaint> findAll(Complaint complaint);
}
