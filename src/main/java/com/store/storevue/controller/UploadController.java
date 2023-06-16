package com.store.storevue.controller;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Api(tags = " 图片上传测试接口")
@RestController
@RequestMapping("/api")
public class UploadController {

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // 保存文件到指定路径
            String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
            String filePath = "D:/Project/store/src/main/resources/images/" + fileName;  // 指定保存文件的路径
            file.transferTo(new File(filePath));
            // 返回文件路径给前端
            Map<String, Object> response = new HashMap<>();
            response.put("imageUrl", filePath);
            response.put("imageName", fileName);
            System.out.println("imageUrl="+filePath);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            // 处理文件保存异常
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @DeleteMapping("/deleteImage")
    public ResponseEntity<?> deleteImage(@RequestParam("filePath") String filePath) {
        // 构造文件对象
        File file = new File(filePath);

        // 删除文件
        if (file.delete()) {
            System.out.println("删除成功");
            return ResponseEntity.ok().build(); // 删除成功返回 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 删除失败返回 500 Internal Server Error
        }
    }
    // 其他方法和逻辑
}
