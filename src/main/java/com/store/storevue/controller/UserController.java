package com.store.storevue.controller;

import com.store.storevue.Utils.JwtUtil;
import com.store.storevue.pojo.User;

import com.store.storevue.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = " 用户测试接口")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private  JwtUtil jwtUtil;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/info")
    public ResponseEntity<User> getUserInfo(HttpServletRequest request) {
        // 从请求头中获取token
        String token = request.getHeader("Authorization").replace("Bearer ", "");

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
    @GetMapping("/users")
    public List<User> getUsers() {
        // 使用 MyBatis-Plus 查询数据库获取用户列表
        List<User> userList = userService.getAllUsers();
        return userList;
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id) {
        boolean result = userService.deleteUserById(id);
        if (result) {
            return "用户删除成功";
        } else {
            return "用户删除失败.";
        }
    }
}

