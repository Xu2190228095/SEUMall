package com.example.demo.service.impl;

import com.example.demo.dao.ComplaintDao;
import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Scope("prototype")
public class ComplaintServiceImpl implements ComplaintService {
    @Resource
    private ComplaintDao complaintDao;

    @Override
    public int delete(Complaint complaint) {
        return complaintDao.delete(complaint);
    }

    @Override
    public List<Complaint> findAll(Complaint complaint) {
        return complaintDao.findAll(complaint);
    }

    @Override
    public int insert(Complaint complaint) {
        return complaintDao.insert(complaint);
    }

    @Override
    public int update(Complaint complaint) {
        return complaintDao.update(complaint);
    }
}
