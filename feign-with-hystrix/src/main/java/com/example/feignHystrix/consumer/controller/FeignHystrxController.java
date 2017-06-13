package com.example.feignHystrix.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.feignHystrix.consumer.feign.UserFeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by coco on 17/6/11.
 */
@RestController
public class FeignHystrxController {

    @Autowired
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("/feign-hystrix/{user_id}")
    public JSONObject findUserById(@PathVariable("user_id") Long userId){
        return userFeignHystrixClient.findByIdFeign(userId);
    }
}
