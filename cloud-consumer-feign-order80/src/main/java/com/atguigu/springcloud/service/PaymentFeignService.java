package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entityes.CommonResult;
import com.atguigu.springcloud.entityes.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-19 18:06
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String getPaymentTimeout();

}
