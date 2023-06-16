package com.store.storevue.controller;

import com.store.storevue.pojo.Order;
import com.store.storevue.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
public class OrderController {

        private final OrderService orderService;

        public OrderController(OrderService orderService) {
            this.orderService = orderService;
        }
        @PostMapping("/create/order")
        public void createOrder(@RequestBody Order order) {
            order.setOrderDate(new Date());
            orderService.createOrder(order);
//            删除购物车
            orderService.deleteCartItemsByUserId(order.getUserId());
        }
        @GetMapping("/orders/{userId}")
        public List<Order> getOrdersWithDetailsByUserId(@PathVariable Integer userId) {
            return orderService.getOrdersWithDetailsByUserId(userId);
        }
    }

