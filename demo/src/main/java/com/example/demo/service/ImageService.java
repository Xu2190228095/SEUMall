package com.example.demo.service;

import com.example.demo.entity.Image;

import java.util.List;

/**
 * @author 18536
 */
public interface ImageService {
    public Image findAll(String originUrl_info);
    public int insert(Image image);
    public int update(Image image);
    public int delete(Image image);

}
