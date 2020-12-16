package top.btiqian.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon & restTemplate
 * @author echo lovely
 * @date 2020/12/16 12:00
 */

@Configuration
public class ApplicationContextConfig {

    @LoadBalanced // 开启负载均衡
    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }

}
