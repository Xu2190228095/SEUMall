package com.example.demo.service;

import com.example.demo.entity.Comments;

import java.util.List;

public interface CommentsService {
    public int delete(Comments comments);
    public List<Comments> findAll(Comments comments);
    public int insert(Comments comments);
    public int update(Comments comments);
    public List<Comments> findByPid(Integer pid);


    public int getAverageScore(Integer pid);

    public List<Integer> getAllScores(Integer pid);
}
