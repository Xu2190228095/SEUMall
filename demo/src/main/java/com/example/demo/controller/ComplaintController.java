package com.example.demo.controller;

import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/complaint")
@CrossOrigin(origins="*")
public class ComplaintController {
    @Resource
    private ComplaintService complaintService;

    @GetMapping("list")
    public Object queryList(Complaint complaint) {
        return complaintService.findAll(complaint);
    }
}
