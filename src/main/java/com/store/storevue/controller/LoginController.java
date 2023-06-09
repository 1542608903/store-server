package com.store.storevue.controller;

import com.store.storevue.Utils.JwtUtil;
import com.store.storevue.pojo.LoginResponse;
import com.store.storevue.pojo.User;
import com.store.storevue.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
//        获取前端数据
        String username = user.getUsername();
        String password = user.getPassword();

        if(userService.authenticate(username, password)) {
                String token = JwtUtil.generateToken(username); // 生成登录成功的token
                return ResponseEntity.ok(new LoginResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登录失败，用户名或密码错误");
        }
    }
}
