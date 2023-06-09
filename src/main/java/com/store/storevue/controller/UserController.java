package com.store.storevue.controller;

import com.store.storevue.Utils.JwtUtil;
import com.store.storevue.pojo.User;

import com.store.storevue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private  JwtUtil jwtUtil;
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userinfo")
    public ResponseEntity<User> getUserInfo(HttpServletRequest request) {
        // 从请求头中获取token

        String token = request.getHeader("Authorization").replace("Bearer ", "");
//        System.out.println("mytoken:"+token);

        // 解析token，获取用户名
        String username = JwtUtil.getUsernameFromToken(token);

        // 根据用户名查询用户信息
        if (username != null) {
            User user = userService.getUserByUsername(username);
            if (user != null) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.notFound().build();

    }
@PutMapping("update/{id}")
public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
    user.setId(id); // 设置要更新的用户ID
    User updatedUser = userService.updateUser(user); // 调用UserService的updateUser方法进行用户信息更新
    if (updatedUser != null) {
        return ResponseEntity.ok(updatedUser); // 更新成功，返回修改后的用户信息
    } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 更新失败，返回错误状态
    }
}
}

