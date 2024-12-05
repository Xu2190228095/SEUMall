package com.example.demo.controller;

import com.example.demo.mq.*;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Resource
    private SimpleSender simpleSender;

    @GetMapping(value = "/simple")
    public Object simpleTest() {
        for(int i=0;i<10;i++){
            simpleSender.send();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "success";
    }
}