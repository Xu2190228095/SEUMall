package com.example.demo.dao;

import com.example.demo.entity.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ImageDao {
    public List<Image> findAll(Image Image);
    public int insert(Image Image);
    public int update(Image Image);
    public int delete(Image Image);

}

