package com.store.storevue.controller;

import com.store.storevue.pojo.Product;
import com.store.storevue.pojo.User;
import com.store.storevue.service.ProductService;
import com.store.storevue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RequestMapping("/api")
public class UploadController {
    @Resource
    private UserService userService;

    @PostMapping("/upload/userImage")
    public String uploadAvatar(@RequestParam("file") MultipartFile file, @RequestParam("Id") Integer Id) {
        if (!file.isEmpty()) {
            try {
                // 保存上传的文件到服务器
                String filePath = saveFile(file);
                System.out.println("文件路径："+filePath);

                // 更新用户头像路径
                User user = userService.getUserById(Id);
                user.setUserImage(filePath);
                userService.updateUser(user);

                return filePath;
            } catch (Exception e) {
                e.printStackTrace();
                // 处理文件上传异常
                return "File upload failed: " + e.getMessage();
            }
        }
        return "No file selected.";
    }
    // 保存文件到服务器并返回文件路径
//    @PostMapping("/upload")
    private String saveFile(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        // 生成一个唯一的文件名，可以使用UUID
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        // 指定文件保存的路径
        String filePath = "D:/Project/store/src/main/resources/images" + fileName;
        // 保存文件到指定路径
        file.transferTo(new File(filePath));
        return filePath;
    }
}
