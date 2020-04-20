package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entityes.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-15 21:22
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
