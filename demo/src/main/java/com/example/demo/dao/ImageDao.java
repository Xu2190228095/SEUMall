package com.example.demo.dao;

import com.example.demo.entity.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ImageDao {
    public Image findAll(String originUrl_info);
    public int insert(Image Image);
    public int update(Image Image);
    public int delete(Image Image);

}

