package com.example.ribbon.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by coco on 17/5/13.
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${from}")
    private String from;

    @GetMapping(value = "/ribbon-consumer")
    public JSONObject getHelloWorld(){
        return restTemplate.getForEntity("http://user-provider/1",JSONObject.class).getBody();
    }

    @GetMapping("/from")
    public String getGitProp(){
        return this.from;
    }
}
