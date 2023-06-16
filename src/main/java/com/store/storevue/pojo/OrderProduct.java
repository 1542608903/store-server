package com.store.storevue.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("order_product")
public class OrderProduct {
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Double price;

    public Integer getOrderId(){
        return  orderId;
    }
    public void setOrderId(Integer orderId){this.orderId=orderId;}

    public Integer getProductId(){return productId;}
    public void setProductId(Integer productId){this.productId=productId;}

    public Integer getQuantity(){return quantity;}
    public void setQuantity(Integer quantity){this.quantity=quantity;}

    public Double getPrice(){return price;}
    public void setPrice(Double price){this.price = price;}


    @Override
    public String toString() {
        return "OrderProduct{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
