package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-19 19:39
 */
@Service
public class PaymentService {

    /**
     * 正常访问成功的方法
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池: "+Thread.currentThread().getName()+"paymentInfo_OK  "+id+"\t"+"Ok";
    }


    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+"paymentInfo_TimeOut  "+id+"\t"+"Ok"+"~耗时(秒)"+timeNumber;
    }



}
