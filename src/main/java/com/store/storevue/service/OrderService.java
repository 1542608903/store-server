package com.store.storevue.service;

import com.store.storevue.mapper.OrderMapper;
import com.store.storevue.mapper.OrderProductMapper;
import com.store.storevue.mapper.ProductMapper;
import com.store.storevue.pojo.Order;
import com.store.storevue.pojo.OrderProduct;
import com.store.storevue.pojo.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderProductMapper orderProductMapper;
    private final CartService cartService;
    private final ProductMapper productMapper;

    public OrderService(OrderMapper orderMapper, OrderProductMapper orderProductMapper,CartService cartService,ProductMapper productMapper) {
        this.orderMapper = orderMapper;
        this.orderProductMapper = orderProductMapper;
        this.cartService = cartService;
        this.productMapper = productMapper;
    }


    public List<Order> getOrdersWithDetailsByUserId(Integer userId) {
        return orderMapper.selectOrdersWithDetailsByUserId(userId);
    }
    public void createOrder(Order order) {
        // 插入订单数据
        orderMapper.insert(order);
        // 插入订单详情数据
        List<OrderProduct> orderProducts = order.getOrderProducts();
        for (OrderProduct orderProduct : orderProducts) {
            orderProduct.setOrderId(order.getId());
            orderProductMapper.insert(orderProduct);

            Integer productId = orderProduct.getProductId();
            Integer quantity = orderProduct.getQuantity();
            Product product = productMapper.selectById(productId);
            if (product != null) {
                Integer currentStock = product.getStock();
                Integer updatedStock = currentStock - quantity;
                product.setStock(updatedStock);
                productMapper.updateById(product);
            }
        }
    }

    public void deleteCartItemsByUserId(Integer userId) {
        cartService.deleteCartItemsByUserId(userId);
    }
}
