package com.example.zuul;

import com.example.zuul.access.AccessFilter;
import com.example.zuul.error.ErrorFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by coco on 17/5/26.
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

    @Bean
    AccessFilter accessFilter() {
        return new AccessFilter();
    }

    @Bean
    ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
