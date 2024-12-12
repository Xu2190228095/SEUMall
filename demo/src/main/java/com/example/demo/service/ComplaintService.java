package com.example.demo.service;

import com.example.demo.entity.Complaint;

import java.util.List;

public interface ComplaintService {
    public int delete(Complaint complaint);
    public List<Complaint> findAll(Complaint complaint);
    public int insert(Complaint complaint);
    public int update(Complaint complaint);
}
