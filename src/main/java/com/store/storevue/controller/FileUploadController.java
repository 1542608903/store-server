package com.store.storevue.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Controller
public class FileUploadController {
/*
    @Value("${upload.dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {

        // 检查上传文件是否为空
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("上传文件不能为空");
        }

        try {
            // 检查并创建目录
            createDirectoryIfNeeded(uploadDir);

            // 生成唯一的文件名
            String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
            // 定义文件路径
            Path filePath = Paths.get(uploadDir,fileName);

            // 复制文件到目标路径
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // 构建图片URL
            String fileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/images/")
                    .path(fileName)
                    .toUriString();

            return ResponseEntity.ok().body(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("文件上传失败");
        }
    }

    private void createDirectoryIfNeeded(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            Files.createDirectories(directory.toPath());
        }
    }*/
}
