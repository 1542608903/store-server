package com.store.storevue.controller;

import com.store.storevue.pojo.User;
import com.store.storevue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class UserListController {
    @Autowired
    private  UserService userService;

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
