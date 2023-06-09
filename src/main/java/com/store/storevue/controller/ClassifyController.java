package com.store.storevue.controller;

import com.store.storevue.mapper.ClassifyMapper;
import com.store.storevue.pojo.Classify;
import com.store.storevue.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;

    public ClassifyController(ClassifyService classifyService) {
        this.classifyService = classifyService;
    }

    // 查询所有分类
    @GetMapping("/classify")
    public List<Classify> getClassify() {
        // 使用 MyBatis-Plus 查询数据库获取用户列表
        return classifyService.getAllClassify();
    }
    // 根据分类ID查询分类

    // 创建分类
    @PostMapping("/classifySave")
    public ResponseEntity<?> addCategory(@RequestBody Classify classify) {
        classifyService.ClassifySave(classify);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 更新分类

    // 删除分类
    @DeleteMapping("/delete/classify/{classifyId}")
    public String deleteClassify(@PathVariable Integer classifyId) {
        boolean result = classifyService.deleteClassifyById(classifyId);
        if (result) {
            return "删除成功";
        } else {
            return "删除失败.";
        }
    }
}