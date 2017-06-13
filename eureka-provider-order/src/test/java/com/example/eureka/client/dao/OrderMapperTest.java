package com.example.eureka.client.dao;

import com.example.eureka.client.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by coco on 17/5/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderMapperTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void findByUserId() throws Exception {
        List<Order> orders = new ArrayList<>(3);
        Order order = new Order();
        order.setFkUserId(1l);
        order.setSn(UUID.randomUUID().toString().substring(0,32));
        orderRepository.save(order);
        Order order1 = new Order();
        order1.setFkUserId(1l);
        order1.setSn(UUID.randomUUID().toString().substring(0,32));
        orderRepository.save(order1);
        Order order2 = new Order();
        order2.setFkUserId(1l);
        order2.setSn(UUID.randomUUID().toString().substring(0,32));
        orderRepository.save(order2);
        assert  orderRepository.findByFkUserId(1l).size() == 3;
    }

}