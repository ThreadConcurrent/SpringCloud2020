package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-19 15:59
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
