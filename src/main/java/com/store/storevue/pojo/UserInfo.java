package com.store.storevue.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("users")
public class UserInfo {
    private  String username;
    private  String name;

    public UserInfo(String username, String name) {
        this.username = username;
        this.name = name;
    }
    public String getName(){return name;}
    public  void setName(String name){this.name=name;}

    public  String getUsername(){
        return username;
    }
    public  void setUsername(String username){
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
