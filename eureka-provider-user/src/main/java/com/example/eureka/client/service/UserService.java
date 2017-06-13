package com.example.eureka.client.service;

import com.alibaba.fastjson.JSONArray;
import com.example.eureka.client.domain.User;

/**
 * Created by coco on 17/5/27.
 */
public interface UserService {
    User register(User user);
    Boolean login(User user);
    User findById(Long id);
}
