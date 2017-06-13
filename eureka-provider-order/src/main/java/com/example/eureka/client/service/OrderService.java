package com.example.eureka.client.service;

import com.example.eureka.client.domain.Order;

import java.util.List;

/**
 * Created by coco on 17/5/27.
 */
public interface OrderService {

    List<Order> findByUserId(Long fkUserId);

    Order insert(Long userId);
}
