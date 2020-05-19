package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-20 21:53
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService---fall back,paymentInfo_OK--------------------";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService---fall back,paymentInfo_TimeOut Error!!!!!----------------";
    }
}
