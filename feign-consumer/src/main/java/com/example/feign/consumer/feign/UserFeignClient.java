package com.example.feign.consumer.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by coco on 17/6/11.
 */
@FeignClient(name = "user-provider")
public interface UserFeignClient {

    @RequestMapping("/{user_id}")
    JSONObject findUserById(@PathVariable("user_id") Long userId);

}
