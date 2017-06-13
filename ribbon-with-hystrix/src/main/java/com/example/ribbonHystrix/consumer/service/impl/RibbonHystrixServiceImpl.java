package com.example.ribbonHystrix.consumer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.ribbonHystrix.consumer.service.RibbonHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by coco on 17/6/11.
 */
@Service
public class RibbonHystrixServiceImpl implements RibbonHystrixService {

    protected final Logger logger = LoggerFactory.getLogger(RibbonHystrixServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    @Override
    public JSONObject findUserWithHystrix(Long userId) {
        return restTemplate.getForEntity("http://user-provider/" + userId,JSONObject.class).getBody();
    }

    public JSONObject fallback(Long userId){
        logger.warn("user-provider服务发生异常，熔断处理，参数userId:{}",userId);
        JSONObject user = new JSONObject();
        user.put("id",-1L);
        user.put("name","default name");
        user.put("password","default password");
        return user;
    }
}
