package top.bitqian.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * restTemplate
 * @author echo lovely
 * @date 2020/12/6 11:59
 */

@Configuration
public class ApplicationContextConfig {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }

}
