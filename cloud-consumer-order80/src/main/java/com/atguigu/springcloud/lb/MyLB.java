package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-19 16:01
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int concurrent;
        int next;
        do{
            concurrent = atomicInteger.get();
            next = concurrent >= 2147483647?0:concurrent+1;

        }while (!this.atomicInteger.compareAndSet(concurrent,next));
        System.out.println("********第几次访问次数,次数next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

}
