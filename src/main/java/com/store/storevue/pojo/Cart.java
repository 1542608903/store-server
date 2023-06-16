package com.store.storevue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;



public class Cart {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer quantity;

    public Integer getId(){
        return id;
    }
    public void setId(int id){this.id=id;}

    public Integer getUserId(){return userId;}
    public void setUserId(int userId){this.userId=userId;}

    public Integer getProductId(){return productId;}
    public void setProductId(int productId){this.productId=productId;}

    public Integer getQuantity(){return quantity;}
    public void setQuantity(int quantity){this.quantity=quantity;}

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
