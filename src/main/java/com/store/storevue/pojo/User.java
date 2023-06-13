package com.store.storevue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//表名和类名不一致 使用@TableName("用户表")
@TableName("users")
public class User {
//    id自增
    @TableId(type = IdType.AUTO)
    private  int id;
    private String name;
    private String sex;
    private String age;
    private String createDate;
    private String username;
    private String password;
    private String userImage;
    private boolean isAdmin;
    private String address;

    public int getId(){
        return id;
    }
    public void  setId(int id){this.id=id;}

    public boolean getRole(){
        return isAdmin;
    }
    public void  setRole(boolean isAdmin){this.isAdmin=isAdmin;}
//姓名
    public String getName(){return name;}
    public  void setName(String name){this.name=name;}

    public String getSex(){return sex;}
    public  void setSex(String sex){this.sex=sex;}

    public String getAge(){return age;}
    public  void setAge(String age){this.age=age;}

    public String getCreateDate(){return createDate;}
    public  void setCreateDate(String createDate){this.createDate=createDate;}

    public  String getUsername(){
        return username;
    }
    public  void setUsername(String username){
        this.username = username;
    }

    public  String getPassword(){
        return password;
    }
    public  void setPassword(String password){
        this.password = password;
    }

    public String getUserImage(){return  userImage;}
    public void  setUserImage(String userImage){this.userImage=userImage;}

    public  String getAddress(){return  address;}
    public  void  setAddress(String address){this.address = address;}


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", createDate='" + createDate + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userImage='" + userImage + '\'' +
                ", isAdmin=" + isAdmin +
                ", address='" + address + '\'' +
                '}';
    }
}
