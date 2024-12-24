package com.example.demo.service.impl;

import com.example.demo.config.FastDFSConfig;
import com.example.demo.service.FileUploadService;
import com.example.demo.config.FastDFSConfig ;
import jakarta.annotation.Resource;
import org.csource.common.MyException;
import org.csource.fastdfs.StorageClient1;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Resource
    private FastDFSConfig fastDFSConfig;
    private StorageClient1 getStorageClient() {
        return fastDFSConfig.getStorageClient();
    }
    @Override
    public String uploadFile(MultipartFile file) throws IOException, MyException
    {
// 获取文件的原始文件名和扩展名
        String originalFilename = file.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".")
                + 1);
// 调用StorageClient的upload_file方法上传文件
        String[] uploadResults = getStorageClient().upload_file(file.getBytes(),
                ext, null);
        // 返回文件的访问路径（通常是组名和文件名）
        return uploadResults[0] + "/" + uploadResults[1];
    }

    @Override
    public byte[] downLoadFile(String fileUrl) throws IOException, MyException {
        String group = fileUrl.substring(0, fileUrl.indexOf("/"));
        String path = fileUrl.substring(fileUrl.indexOf("/") + 1);
        byte[] bytes = getStorageClient().download_file(group, path);
        return bytes;
    }
}
