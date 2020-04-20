package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entityes.CommonResult;
import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-19 18:10
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/comsumer/payment/feign/timeout")
    public String paymentFeigntimeout(){
        // openfrign-ribbon,客户端默认等待1秒钟
       return paymentFeignService.getPaymentTimeout();
    }
}
