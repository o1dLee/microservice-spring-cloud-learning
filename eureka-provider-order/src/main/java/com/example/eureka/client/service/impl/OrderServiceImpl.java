package com.example.eureka.client.service.impl;

import com.example.eureka.client.dao.OrderRepository;
import com.example.eureka.client.domain.Order;
import com.example.eureka.client.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by coco on 17/5/27.
 */
@Service
public class OrderServiceImpl implements OrderService {

    protected static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> findByUserId(Long fkUserId) {
        return orderRepository.findByFkUserId(fkUserId);
    }

    @Override
    public Order insert(Long userId) {
        if (userId == null) {
            return null;
        }
        Order order = new Order();
        order.setFkUserId(userId);
        order.setSn(UUID.randomUUID().toString());
        return orderRepository.save(order);
    }
}
