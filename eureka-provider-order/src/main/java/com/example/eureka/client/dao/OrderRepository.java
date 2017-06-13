package com.example.eureka.client.dao;

import com.example.eureka.client.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by coco on 17/5/27.
 */
public interface OrderRepository extends JpaRepository<Order,Long>{

    List<Order> findByFkUserId(Long fkUserId);
}
