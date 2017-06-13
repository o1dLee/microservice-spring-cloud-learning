package com.example.feign.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.feign.consumer.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by coco on 17/6/11.
 */
@RestController
public class FeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/feign-consumer/{user_id}")
    public JSONObject findUserById(@PathVariable("user_id") Long userId){
        return userFeignClient.findUserById(userId);
    }
}
