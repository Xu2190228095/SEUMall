package com.example.demo.controller;

import com.example.demo.entity.Comments;
import com.example.demo.service.CommentsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comments")
public class CommentsController {
    @Resource
    private CommentsService commentsService;

    @GetMapping("/insert")
    public int insert(Comments comments) {
        return commentsService.insert(comments);
    }

    @GetMapping("/findByPid")
    public Object findByPid(Integer pid) {
        return commentsService.findByPid(pid);
    }

    @GetMapping("/getAverageScore")
    public Object getAverageScore(Integer pid) {
        return commentsService.getAverageScore(pid);
    }

    @GetMapping("/getAllScores")
    public Object getAllScores(Integer pid) {
        return commentsService.getAllScores(pid);
    }

}
