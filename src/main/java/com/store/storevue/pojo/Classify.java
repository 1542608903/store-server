package com.store.storevue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("classify")
public class Classify {
    @TableId(type = IdType.AUTO)
    private Integer classifyId;

    private String classifyName;

    public Integer getClassifyId(){return classifyId;}
    public void setClassifyId(Integer classifyId){
        this.classifyId=classifyId;
    }

    public String getClassifyName(){return classifyName;}
    public  void setClassifyName(String classifyName){this.classifyName=classifyName;}

    @Override
    public String toString() {
        return "Classify{" +
                "classifyId=" + classifyId +
                ", classifyName='" + classifyName + '\'' +
                '}';
    }
}
