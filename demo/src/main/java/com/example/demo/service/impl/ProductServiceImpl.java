package com.example.demo.service.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Scope("prototype")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    @Override
    public int delete(Product product) {
        return productDao.delete(product);
    }

    @Override
    public List<Product> findAll(Product product) {
        return productDao.findAll(product);
    }

    @Override
    public int insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public int update(Product product) {
        return productDao.update(product);
    }
}
