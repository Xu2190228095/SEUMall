package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import jakarta.annotation.Resource;
import org.csource.common.MyException;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Resource
    private OrderService orderService;

    @Resource
    private CustomerService customerService;

    @Resource
    private FileUploadService fileUploadService;

    @Resource
    private UserService userService;
    @GetMapping("/list")
    public Object queryList(Product product) {
        System.out.println("reach step 1");
        return this.productService.findAll(product);
    }
    @GetMapping("/insert")
    public Object insert(Product product) {
        System.out.println("product:"+product);
        SecurityContext securityContext = SecurityContextHolder.getContext();//获取用户上下文对象
        String username = securityContext.getAuthentication().getName();//获取用户名
        User user = userService.findByUsername(username);
        product.setCid(user.getUid());
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
    public Map<String, Object> fetchProduct(@RequestParam("productid") Integer productid) throws MyException, IOException {
        Map<String, Object> map = new HashMap<>();
        Product product = this.productService.fetchProduct(productid);
        map.put("product",product);
        map.put("picture",this.fileUploadService.downLoadFile(this.productService.findRemoteUrl(product.getImg())));
        return map;
    }

    @GetMapping("/findByProductClass")
    public Object findByProductClass(String productClass) throws MyException, IOException {
        Map<String, Object> map = new HashMap<>();
        List<Product> products = this.productService.findByProductClass(productClass);
        map.put("products",products);
        List<byte[]> pictures = new ArrayList<>();
        for (Product product:products){
            String remoteUrl = this.productService.findRemoteUrl(product.getImg());
            pictures.add(fileUploadService.downLoadFile(remoteUrl));
        }
        map.put("pictures",pictures);
        return map;
    }

    @GetMapping("/fetchList")
    public Map<String, Object> fetchList(int pageNum, int pageSize,Product product) throws MyException, IOException {
        Map<String, Object> map = new HashMap<>();
        List<Product> products = this.productService.fetchList(pageNum, pageSize, product);
        List<byte[]> pictures = new ArrayList<>();
        for (Product prod:products){
            String remoteUrl = this.productService.findRemoteUrl(prod.getImg());
            pictures.add(fileUploadService.downLoadFile(remoteUrl));
        }
        map.put("list",products);
        map.put("pictures",pictures);
        map.put("total",this.productService.searchTotal(product));
        return map;
    }


    @GetMapping("/searchByProductName")
    public Object searchByProductName(String productName,Integer sortOption) throws MyException, IOException {
        Map<String, Object> map = new HashMap<>();
        List<Product> products = this.productService.findByProductName(productName,sortOption);
        map.put("products",products);
        List<byte[]> pictures = new ArrayList<>();
        for (Product product:products){
            String remoteUrl = this.productService.findRemoteUrl(product.getImg());
            pictures.add(fileUploadService.downLoadFile(remoteUrl));
        }
        map.put("pictures",pictures);
        return map;
    }

    @GetMapping("/purchase")
    public Object purchase(Integer pid, Integer number, Integer cid, String desc) {
        System.out.println("pid:"+pid+"number:"+number+"cid:"+cid+"desc:"+desc);
        Order order = new Order();
        order.setPid(pid);
        order.setNumber(number);
        order.setCid(cid);
        order.setRemark(desc);
        order.setOrder_id(System.currentTimeMillis()+"");
        order.setState("待发货");
        order.setCreate_time(new java.util.Date(System.currentTimeMillis()));
        Product product = productService.findByProductid(pid);
        order.setUid(product.getCid());
        orderService.insert(order);
        product.setNumber(product.getNumber()-number);//校验数量
        productService.update(product);
        Customer customer=customerService.getCustomerByCid(cid);
        customer.setAccount(customer.getAccount()-product.getPrice()*number);
        customerService.updateCustomerInfo(customer);
        return 1;
    }

}
