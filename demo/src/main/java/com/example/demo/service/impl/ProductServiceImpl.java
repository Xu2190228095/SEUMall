package com.example.demo.service.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Override
    public Product findByProductname(String productname) {
        return productDao.findByProductname(productname);
    }
    @Override
    public Product findByProductid(Integer productid) {
        return productDao.findByProductid(productid);
    }

    @Override
    public List<Product> fetchList(int page, int size, Product product) {
        Map<String, Object> map = new HashMap<>();
        int start = (page - 1) * size;
        map.put("start", start);
        map.put("size", size);
        map.put("productInfo", product);
        return productDao.fetchList(map);
    }

    @Override
    public Object searchTotal(Product product) {
        return productDao.searchTotal(product);
    }
}
