package com.example.zookeeper.discovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by coco on 17/5/16.
 */
@RestController
public class AdderController {

    @GetMapping("/adder")
    public Integer adder(@RequestParam("a") Integer a,@RequestParam("b") Integer b){
        if (null != a && null != b){
            return a + b;
        }
        return -999999;
    }
}
