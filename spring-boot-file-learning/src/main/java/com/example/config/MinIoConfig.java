package com.example.config;

import io.minio.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class MinIoConfig {
    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    private MinioClient instance;

    @PostConstruct
    public void init(){
        instance = MinioClient.builder()
                .endpoint(endPoint)
                .credentials(accessKey,secretKey)
                .build();
    }

    /**
     * 判断bucket是否存在
     */
    public boolean bucketExists(String bucketName) throws Exception{
        return instance.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    public void makeBucket(String bucketName) throws Exception{
        if (!bucketExists(bucketName)) {
            instance.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    public ObjectWriteResponse uploadObject(String bucketName, String objectName, String filePath) throws Exception{
        return instance.uploadObject(UploadObjectArgs.builder().bucket(bucketName).object(objectName).filename(filePath).build());
    }

    public void removeObject(String bucketName, String objectName) throws Exception{
        instance.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }

    /**
     * 文件上传
     * @param bucketName 存储桶名称
     * @param objectName 文件名
     * @param filePath 存储目录
     * @return 响应结果
     */
    public ObjectWriteResponse putObject(String bucketName, String objectName, String filePath, InputStream inputStream) throws Exception{
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(inputStream, -1, 10485760)
                .build();
        return instance.putObject(putObjectArgs);
    }

    public void removeBucket(String bucketName) throws Exception {
        if (bucketExists(bucketName)) {
            instance.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
        }
    }
}
