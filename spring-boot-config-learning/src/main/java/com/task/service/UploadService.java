package com.task.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.task.config.OssConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Component
public class UploadService {

    @Autowired
    private OssConfig ossConfig;

    public String ossUpload(MultipartFile file){
        String endpoint= ossConfig.getEndpoint();
        String bucket= ossConfig.getBucket();
        String dir= ossConfig.getDir();
        String host= ossConfig.getHost();
        String accessKeyId= ossConfig.getAk();
        String accesskeySecret= ossConfig.getSecret();

        OSS ossClient = new OSSClientBuilder().build(endpoint,accessKeyId,accesskeySecret);

        String uploadPath = dir + file.getOriginalFilename();

        InputStream ins = null;
        try {
            ins = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ossClient.putObject(bucket,uploadPath,ins);
        ossClient.shutdown();

        return host + uploadPath;
    }

}
