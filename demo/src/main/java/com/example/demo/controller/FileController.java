package com.example.demo.controller;

import com.example.demo.service.FileUploadService;
import com.example.demo.service.ProductService;
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

    @Resource
    private ProductService productService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws
            IOException {
        String filePath;
        System.out.println("file:"+file.getOriginalFilename());
        try {
            filePath = fileUploadService.uploadFile(file);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        productService.insertImgMap(file.getOriginalFilename(), filePath);
        return "File uploaded successfully. File path: " + filePath;
    }

    @PostMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestBody String fileUrl) throws IOException, MyException {
        System.out.println("fileUrl:"+fileUrl);
        byte[] fileContent = fileUploadService.downLoadFile(fileUrl);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + fileUrl)
                .body(fileContent);
    }


}