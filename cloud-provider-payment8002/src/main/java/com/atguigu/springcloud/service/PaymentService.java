package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entityes.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-15 21:35
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);

}
