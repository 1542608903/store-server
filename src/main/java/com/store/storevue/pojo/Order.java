package com.store.storevue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
@TableName("order_info")
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderDate;
    private Double total;


    @TableField(exist = false)
    private List<OrderProduct> orderProducts;

    public Order() {
    }

    public Integer getId(){return id;}
    public void setId(Integer id){this.id=id;}

    public Integer getUserId(){return  userId;}
    public void setUserId(Integer userId){this.userId=userId;}

    public Date getOrderDate(){return orderDate;}
    public void setOrderDate(Date orderDate){this.orderDate=orderDate;}

    public Double getTotal(){return total;}
    public void setTotal(Double total){this.total=total;}

    public List<OrderProduct> getOrderProducts(){return  orderProducts;}
    public void setOrderProducts(List<OrderProduct> orderProducts){this.orderProducts=orderProducts;}


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderDate='" + orderDate + '\'' +
                ", total=" + total +
                ", orderProducts=" + orderProducts +
                '}';
    }
}