package com.example.zookeeper.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by coco on 17/5/17.
 */
@RestController
public class AdderConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @PostMapping("/zookeeper-consumer")
    public Integer getAdder(@RequestParam("a") Integer a, @RequestParam("b")Integer b){
        ServiceInstance serviceInstance = loadBalancer.choose("microservice-zookeeper-client");
        Map<String,Object> params = new HashMap<>();
        params.put("a",a);
        params.put("b",b);
        return restTemplate.getForEntity("http://microservice-zookeeper-client/adder",Integer.class,params).getBody();
    }

}
