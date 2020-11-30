package top.bitqian.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * restTemplate 封装了httpClient
 * 用来从一个端口调用另一个端口接口
 * @author echo lovely
 * @date 2020/11/30 19:35
 */

// 配置类
@Configuration
public class ApplicationContextConfig {

    // 将这个RestTemplate丢入容器.
    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }

}
