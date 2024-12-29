package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Image;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.service.*;
import com.sun.tools.jconsole.JConsoleContext;
import jakarta.annotation.Resource;
import org.csource.common.MyException;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 星星不说话
 */
@RestController
@Scope("prototype")
@RequestMapping("/image")
@CrossOrigin(origins="*")
public class ImageController {
    @Resource
    private ImageService imageService;

    @GetMapping("/list")
    public Object queryList(Image image) {
        System.out.println("reach step 1");
        return this.imageService.findAll(image);
    }
}
