package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {

    @Value("${web.upload-path}")
    private String uploadPath;

    DateFormat df = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    HttpServletRequest request;

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String format = df.format(new Date());
        File folder = new File(uploadPath + format);
        if (!folder.isDirectory()){
            folder.mkdirs();
        }
        //对上传文件进行重命名 避免冲突
        String oldName = file.getOriginalFilename();
        String newName = null;
        if (oldName != null) {
            newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
        }

        //上传:文件复制搬运
        file.transferTo(new File(folder,newName));

        //拼接返回上传后的访问路径
        String filePath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + format + "/" + newName;
        return filePath;
    }



}
