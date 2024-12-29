package com.example.demo.service.impl;

import com.example.demo.dao.ImageDao;
import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Image;
import com.example.demo.entity.Product;
import com.example.demo.service.ImageService;
import com.example.demo.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Scope("prototype")
public class ImageServiceImpl implements ImageService {
    @Resource
    private ImageDao imageDao;

    @Override
    public int delete(Image image) {
        return imageDao.delete(image);
    }

    @Override
    public Image findAll(String originUrl_info) {
        return imageDao.findAll(originUrl_info);
    }

    @Override
    public int insert(Image image) {
        System.out.println(image);
        return imageDao.insert(image);
    }

    @Override
    public int update(Image image) {
        return imageDao.update(image);
    }

}
