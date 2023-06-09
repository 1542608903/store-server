package com.store.storevue.controller;

import com.store.storevue.mapper.UserMapper;
import com.store.storevue.pojo.User;
import com.store.storevue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    private UserMapper UserMapper;
    private final UserService userService;
    public RegisterController(UserService userService) {
        this.userService = userService;
    }
//   用户注册接口
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        System.out.println("注册信息："+user);
        if (userService.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("用户已被注册！");
        }
        try {
            userService.registerUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("注册成功");
    }
}
