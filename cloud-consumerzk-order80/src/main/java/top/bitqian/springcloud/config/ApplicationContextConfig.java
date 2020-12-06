package top.bitqian.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author echo lovely
 * @date 2020/12/6 10:18
 */

@Configuration
public class ApplicationContextConfig {

    // loadBalanced 赋予restTemplate负载均衡的能力
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {

        // 用于远程调用另一个微服务
        return new RestTemplate();
    }

}
