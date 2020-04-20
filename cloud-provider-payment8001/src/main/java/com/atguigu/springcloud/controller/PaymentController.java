package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entityes.CommonResult;
import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-15 21:37
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("********插入结果:"+result);
        log.info("serverPort="+port);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果:"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功==>serverPort="+port,payment);
        }else{
            return new CommonResult(444,"查询没有对应的数据,查询Id="+id,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        // 获取服务列表清单
        List<String> services = discoveryClient.getServices();
        for(String element:services){
            log.info("*********=>"+element);
        }

        // 获取到一个微服务下面的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return port;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String getPaymentTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

}
