package com.example.ribbonHystrix.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ribbonHystrix.consumer.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by coco on 17/6/11.
 */
@RestController
public class RibbonHystrixController {

    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/ribbon-hystrix-consumer/{user_id}")
    public JSONObject findUserWithHystrix(@PathVariable("user_id") Long userId){
        return ribbonHystrixService.findUserWithHystrix(userId);
    }
}
