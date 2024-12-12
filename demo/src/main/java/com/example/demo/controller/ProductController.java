package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/product")
@CrossOrigin(origins="*")
public class ProductController {
    @Resource
    private ProductService productService;
    @GetMapping("/list")
    public Object queryList(Product product) {
        return this.productService.findAll(product);
    }
}
