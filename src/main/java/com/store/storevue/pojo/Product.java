package com.store.storevue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("goods")
public class Product {
    @TableId(type = IdType.AUTO)
    private Integer gid;
    private String  name;
    private String  detail;
    private Integer stock;
    private Double  price;
    private String  createTime;
    private String  coverImage;
    private Integer classifyId;
    private String  moreImage;

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

    public String getCoverImage(){return coverImage;}
    public void setCoverImage(){this.coverImage=coverImage;}

    public String getMoreImage(){return moreImage;}
    public void setMoreImage(){this.moreImage=moreImage;}

    public Integer getClassifyId(){return classifyId;}
    public void setClassifyId(Integer classifyId){this.classifyId=classifyId;}

    @Override
    public String toString() {
        return "Product{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", createTime='" + createTime + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", classifyId=" + classifyId +
                ", moreImage='" + moreImage + '\'' +
                '}';
    }

    public void setCoverImage(String filePath) {
    }
}
