package com.example.eureka.client.dao;

import com.example.eureka.client.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by coco on 17/5/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserMapperTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByName() throws Exception {
        User user = new User("aa","cc");
        user = userRepository.save(user);
        assert user.getName().equalsIgnoreCase("aa");
        assert user.getId() != null;
    }

}