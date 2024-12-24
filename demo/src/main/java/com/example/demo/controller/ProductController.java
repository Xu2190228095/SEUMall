package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 18536
 */
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
    @GetMapping("/insert")
    public Object insert(Product product) {
        System.out.println("product:"+product);
        return this.productService.insert(product);
    }

    @GetMapping("/delete")
    public Object delete(Product product) {
        System.out.println("product:"+product);
        return this.productService.delete(product);
    }

    @GetMapping("/update")
    public Object update(Product product) {
        System.out.println("product:"+product);
        return this.productService.update(product);
    }

    @GetMapping("/findByProductname")
    public Object findByProductname(String productname) {
        return this.productService.findByProductname(productname);
    }

    @GetMapping("/findByProductid")
    public Object findByProductid(Integer productid) {
        return this.productService.findByProductid(productid);
    }

    // 通过productid查询商品信息
    @GetMapping("/fetchProduct")
    public Object fetchProduct(@RequestParam("productid") Integer productid) {
        return this.productService.fetchProduct(productid);
    }

    @GetMapping("/fetchList")
    public Map<String, Object> fetchList(int pageNum, int pageSize,Product product) {
        Map<String, Object> map = new HashMap<>();
        map.put("list",this.productService.fetchList(pageNum, pageSize, product));
        map.put("total",this.productService.searchTotal(product));
        return map;
    }
}
