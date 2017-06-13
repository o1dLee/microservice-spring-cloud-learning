package com.example.eureka.client.feign;

import com.alibaba.fastjson.JSONArray;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by coco on 17/6/8.
 */
@FeignClient("order-provider")
public interface OrderSericeCient {

    @RequestMapping(value = "/orders/v1/{user_id}")
    JSONArray findUserOrder(@RequestParam("user_id") Long userId);
}
