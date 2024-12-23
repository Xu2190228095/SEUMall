package com.example.demo.controller;

import com.example.demo.service.FileUploadService ;
import jakarta.annotation.Resource;
import org.csource.common.MyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
@RestController
@RequestMapping("/fastdfs")
@CrossOrigin(origins = "*")
public class FileController {
    @Resource
    private FileUploadService fileUploadService;
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws
            IOException {
        String filePath = null;
        try {
            filePath = fileUploadService.uploadFile(file);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "File uploaded successfully. File path: " + filePath;
    }
}