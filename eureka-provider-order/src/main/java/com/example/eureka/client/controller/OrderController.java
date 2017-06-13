package com.example.eureka.client.controller;

import com.example.eureka.client.domain.Order;
import com.example.eureka.client.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by coco on 17/5/27.
 */
@RestController
@RequestMapping("/orders/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestParam("user_id") Long userId){
        if (null == userId) {
            return null;
        }
        return orderService.insert(userId);
    }

    @GetMapping("/{user_id}")
    public List<Order> findUserOrder(@PathVariable("user_id") Long userId){
        if (null == userId){
            return null;
        }
        return orderService.findByUserId(userId);
    }
}
