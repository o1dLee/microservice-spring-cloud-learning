package com.example.eureka.client.dao;

import com.example.eureka.client.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by coco on 17/5/27.
 */
public interface UserRepository extends JpaRepository<User,Long>{
    User findByName(String name);
}
