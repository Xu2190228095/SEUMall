package com.example.demo.config;

import jakarta.annotation.PostConstruct;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
public class FastDFSConfig {
    @Value("${fastdfs.tracker-list}")
    private String trackerList;
    private TrackerClient trackerClient;
    private StorageClient1 storageClient;
    @PostConstruct
    public void init() throws Exception {
        ClientGlobal.initByTrackers(trackerList);

        // 创建TrackerClient和StorageClient对象
        this.trackerClient = new TrackerClient();
        this.storageClient = new StorageClient1();
    }
    public TrackerClient getTrackerClient() {
        return trackerClient;
    }
    public StorageClient1 getStorageClient() {
        return storageClient;
    }
}
