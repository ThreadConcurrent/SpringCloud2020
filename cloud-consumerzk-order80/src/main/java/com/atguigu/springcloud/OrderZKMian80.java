package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-19 10:53
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderZKMian80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMian80.class,args);
    }
}
