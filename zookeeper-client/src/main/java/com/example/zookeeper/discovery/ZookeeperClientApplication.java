package com.example.zookeeper.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by coco on 17/5/16.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperClientApplication.class,args);
    }
}
