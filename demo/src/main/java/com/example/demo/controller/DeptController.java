package com.example.demo.controller;

import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Scope("prototype")
@RequestMapping("/dept")
@CrossOrigin(origins = "*")
public class DeptController {
    @Resource
    private DeptService deptService;

    @GetMapping("/list")
    public Object queryList(Dept dept){
        return this.deptService.findAll(dept);
    }
}
