package com.example.ribbonHystrix.consumer.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by coco on 17/6/11.
 */
public interface RibbonHystrixService {
    JSONObject findUserWithHystrix(Long userId);
}
