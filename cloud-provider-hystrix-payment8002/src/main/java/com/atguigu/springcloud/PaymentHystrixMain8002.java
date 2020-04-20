package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-19 19:38
 */
@EnableEurekaClient
@SpringBootApplication
public class PaymentHystrixMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8002.class,args);
    }
}
