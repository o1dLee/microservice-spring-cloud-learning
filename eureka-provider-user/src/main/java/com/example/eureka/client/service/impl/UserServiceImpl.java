package com.example.eureka.client.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.eureka.client.dao.UserRepository;
import com.example.eureka.client.domain.User;
import com.example.eureka.client.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by coco on 17/5/27.
 */
@Service
public class UserServiceImpl implements UserService {

    protected static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User register(User user) {
        if (user == null){
            throw new RuntimeException("缺少参数");
        }
        if (userRepository.findByName(user.getName()) != null){
            throw new RuntimeException("用户名已存在");
        }
        user = userRepository.save(user);
        if (user.getId() != null){ //说明注册成功
            //发送邮件 TODO  消息总线异步发送
            String userJson = JSONObject.toJSONString(user);

        }
        return user;
    }

    @Override
    public Boolean login(User user) {
        User u = userRepository.findByName(user.getName());
        if (u == null){
            return false;
        }
        if(StringUtils.equals(user.getPassword(),u.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public User findById(Long id) {
        if (id == null){
            return null;
        }
        return userRepository.findOne(id);
    }
}
