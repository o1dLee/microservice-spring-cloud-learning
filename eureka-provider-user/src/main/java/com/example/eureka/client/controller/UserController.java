package com.example.eureka.client.controller;

import com.example.eureka.client.domain.Result;
import com.example.eureka.client.domain.User;
import com.example.eureka.client.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by coco on 17/5/27.
 */
@Api(value = "用户服务", description = "提供用户注册，登录，查询等功能")
@RestController
@RequestMapping("/users/v1")
public class UserController {
    protected static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
    @PostMapping(value = "/register",consumes = "application/json",produces = "application/json")
    public Result register(@ApiParam("用户注册信息")@RequestBody User user){
        User newUser = null;
        try {
            newUser = userService.register(user);
            log.info("user register success：{}", newUser.getName());
        } catch (RuntimeException e) {
            log.warn("user register error : {}",e.getMessage());
            return new Result(false,e.getMessage());
        }
        return new Result(true,newUser);
    }

    @ApiOperation("用户登录")
    @PostMapping(value = "/login", consumes = "application/json",produces = "application/json")
    public Result login(@ApiParam("用户登录参数")@RequestBody User user){
        boolean loginSuccess = userService.login(user);
        if (loginSuccess){
            return new Result("登录成功！");
        }
        return new Result(false,"用户名密码不一致！");
    }

    @ApiOperation("根据用户ID查询用户信息")
    @GetMapping("/{user_id}")
    public Result findById(@ApiParam("用户唯一id")@PathVariable("user_id") Long userId){
        User user = userService.findById(userId);
        if (user == null){
            return new Result(false,"用户不存在");
        }
        return new Result(user);
    }
}
