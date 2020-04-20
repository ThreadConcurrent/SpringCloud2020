package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-19 18:32
 */
@Configuration
public class FeignConfig {

    @Bean
    feign.Logger.Level feignLoggerLevel(){
        return feign.Logger.Level.FULL;
    }

}
