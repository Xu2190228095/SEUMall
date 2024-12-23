package com.example.demo.service;

import org.csource.common.MyException;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
public interface FileUploadService {
    public String uploadFile(MultipartFile file) throws IOException, MyException;
    public byte[] downLoadFile(String fileUrl) throws IOException, MyException;
}
