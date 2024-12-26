package com.example.demo.service.impl;

import com.example.demo.dao.CommentsDao;
import com.example.demo.entity.Comments;
import com.example.demo.service.CommentsService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
@Scope("prototype")
public class CommentsServiceImpl implements CommentsService {
    @Resource
    private CommentsDao commentsDao;

    @Override
    public int delete(Comments comments) {
        return commentsDao.delete(comments);
    }

    @Override
    public List<Comments> findAll(Comments comments) {
        return commentsDao.findAll(comments);
    }

    @Override
    public int insert(Comments comments) {
        return commentsDao.insert(comments);
    }

    @Override
    public int update(Comments comments) {
        return commentsDao.update(comments);
    }

    @Override
    public List<Comments> findByPid(Integer pid) {
        return commentsDao.findByPid(pid);
    }

    @Override
    public int getAverageScore(Integer pid) {
        return commentsDao.getAverageScore(pid);
    }
    @Override
    public List<Integer> getAllScores(Integer pid){return commentsDao.getAllScores(pid);}


}
