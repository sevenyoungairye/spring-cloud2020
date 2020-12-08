package top.bitqian.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 负载均衡 接口--> 轮询~
 */
public interface LoadBalance {

    /**
     * 根据可用的服务实例列表 轮询获取某个实例~
     * @param serviceInstanceList 可用服务实例列表
     * @return 轮询后的某个服务实例~
     */
    ServiceInstance getInstance(List<ServiceInstance> serviceInstanceList);

}
