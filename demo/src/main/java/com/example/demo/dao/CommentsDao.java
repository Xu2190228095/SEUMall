package com.example.demo.dao;

import com.example.demo.entity.Comments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentsDao {
    public int delete(Comments comments);
    public int insert(Comments comments);
    public int update(Comments comments);
    public List<Comments> findAll(Comments comments);
    public List<Comments> findByPid(Integer pid);
    public void save(Comments comment);  // 保存评论
    public int getAverageScore(Integer pid);
    public List<Integer> getAllScores(Integer pid);
}
