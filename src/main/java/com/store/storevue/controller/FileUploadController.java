package com.store.storevue.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@RequestMapping("/api")
public class FileUploadController {
//    创建路径
    public static final String UPLOADS_PATH  = "D:/Project/store/src/main/resources/images";
    @PostMapping("/upload")
    public static String uploads(MultipartFile file) throws IOException{

        final  String fileSuffix  =file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')+1);
//        文件名
        String fileName = UUID.randomUUID().toString()+'-'+fileSuffix;

//       写入
        File descFile = new File(UPLOADS_PATH,fileName);
        file.transferTo(descFile);

        String url = "images" +fileName;

        return url;
    }

}
