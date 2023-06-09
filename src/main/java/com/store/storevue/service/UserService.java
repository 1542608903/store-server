package com.store.storevue.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.store.storevue.mapper.UserMapper;
import com.store.storevue.pojo.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;
    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public boolean authenticate(String username, String password) {
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            return false;
        }

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        if (user != null && password.equals(user.getPassword())) {
            return true;
        }
        return false;
    };

    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    public void createUser(User user) {
        userMapper.insert(user);
    }
//修改用户
    public User updateUser(User user) {
        int rowsAffected = userMapper.updateById(user);
        if (rowsAffected > 0) {
            return userMapper.selectById(user.getId());
        } else {
            return null;
        }
    }
//    删除
    public boolean deleteUserById(Integer id) {
        int result = userMapper.deleteById(id);
        return result > 0;
    }
    public User getUserByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }
    public boolean existsByUsername(String username) {
        // 构建查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("username", username);

        // 调用 MyBatis-Plus 的方法执行查询
        // count() 方法会返回满足条件的记录数，如果大于 0 则表示存在该用户名，否则不存在
        int count = userMapper.selectCount(queryWrapper);

        // 判断是否存在用户名
        return count > 0;
    }
    public User registerUser(User user) throws Exception {
        // 检查用户名是否已存在
        if (existsByUsername(user.getUsername())) {
            throw new Exception("用户名已存在");
        }
        try {
            // 设置用户的其他属性
            // 使用 MyBatis-Plus 的 save 方法插入用户数据
            userMapper.insert(user);

            return user;
        } catch (Exception e) {
            throw new Exception("注册失败");
        }
    }
}

