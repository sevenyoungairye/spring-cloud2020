package top.bitqian.springcloud.lb.impl;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import top.bitqian.springcloud.lb.LoadBalance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 仿照源码写轮询算法
 * @author echo lovely
 * @date 2020/12/8 20:37
 */

@Component
public class MyLoadBalance implements LoadBalance {

    // init 0
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrease() {
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;

        } while (!this.atomicInteger.compareAndSet(current, next)); // 期望值，修改值

        System.out.println("the next value -----> " + next);

        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstanceList) { // 机器列表

        // 得到服务器的下标位置
        int index = getAndIncrease() % serviceInstanceList.size();

        return serviceInstanceList.get(index);
    }
}
