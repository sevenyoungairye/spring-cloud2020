package top.bitqian.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon + restTemplate 配置类 负载均衡远程调用
 * @author echo lovely
 * @date 2020/12/18 21:09
 */

@Configuration
public class ApplicationContextConfig {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }

}
