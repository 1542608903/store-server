package com.store.storevue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.crypto.Data;
import java.util.Date;

@TableName("goods")
public class Product {
    @TableId(type = IdType.AUTO)
    private Integer gid;
    private String  name;
    private String  detail;
    private Integer stock;
    private Double  price;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;
    private String  updateTime;
    private String  coverImage;
    private Integer classifyId;
    private String  moreImage;

    @TableField(exist = false)
    private Integer quantity;

    public Integer getId(){return gid;}
    public void setId(Integer gid){this.gid=gid;}

    public String getName(){return name;}
    public void setName(String name){this.name =name;}

    public String getDetail(){return detail;}
    public void setDetail(String detail){this.detail=detail;}

    public Double getPrice(){return price;}
    public void setPrice(Double price){this.price=price;}

    public Integer getStock(){return stock;}
    public void setStock(Integer stock){this.stock=stock;}

    public String getCreateTime(){return createTime;}
    public void  setCreateTime(String createTime){this.createTime=createTime;}

    public String getUpdateTime(){return updateTime;}
    public void  setUpdateTime(String updateTime){this.updateTime=updateTime;}
    public String getCoverImage(){return coverImage;}
    public void setCoverImage(String coverImage){this.coverImage=coverImage;}

    public String getMoreImage(){return moreImage;}
    public void setMoreImage(String moreImage){this.moreImage=moreImage;}

    public Integer getClassifyId(){return classifyId;}
    public void setClassifyId(Integer classifyId){this.classifyId=classifyId;}


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", classifyId=" + classifyId +
                ", moreImage='" + moreImage + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
